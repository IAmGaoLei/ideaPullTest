import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IMember } from 'app/shared/model/member.model';
import { AccountService } from 'app/core';
import { MemberService } from './member.service';

@Component({
    selector: 'jhi-member',
    templateUrl: './member.component.html'
})
export class MemberComponent implements OnInit, OnDestroy {
    members: IMember[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected memberService: MemberService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {}

    loadAll() {
        this.memberService
            .query()
            .pipe(
                filter((res: HttpResponse<IMember[]>) => res.ok),
                map((res: HttpResponse<IMember[]>) => res.body)
            )
            .subscribe(
                (res: IMember[]) => {
                    this.members = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInMembers();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IMember) {
        return item.id;
    }

    registerChangeInMembers() {
        this.eventSubscriber = this.eventManager.subscribe('memberListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
