import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { IMember } from 'app/shared/model/member.model';
import { MemberService } from './member.service';

@Component({
    selector: 'jhi-member-update',
    templateUrl: './member-update.component.html'
})
export class MemberUpdateComponent implements OnInit {
    member: IMember;
    isSaving: boolean;

    constructor(protected memberService: MemberService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ member }) => {
            this.member = member;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.member.id !== undefined) {
            this.subscribeToSaveResponse(this.memberService.update(this.member));
        } else {
            this.subscribeToSaveResponse(this.memberService.create(this.member));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IMember>>) {
        result.subscribe((res: HttpResponse<IMember>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
