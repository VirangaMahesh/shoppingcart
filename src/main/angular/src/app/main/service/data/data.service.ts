import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AlertServiceService} from "../common/alert-service.service";
import {SETTINGS} from "../../setting/common.setting";
import {throwError} from 'rxjs';
import {Observable} from 'rxjs/index';
import {ShowMessageDto} from "../../dto/show-message-dto";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient,
              private router: Router,
              // private commons: CommonService,
              private alertService: AlertServiceService) {
  }

  public get(conf: any, data?: Object): Observable<Object> {
    return this.request(conf.url, {method: 'GET'}, data, conf.headerParam).pipe(response => {
      return this.responseHandler(response, conf.headerParam.showMessage);
    });
  }

  private request(url: string, options: any, data?: Object, headerParams?: any): Observable<any> {
    options.headers = {};
    let showToaster = false;

    if (!!headerParams) {

      if (headerParams['showToast'] && headerParams['showToast'] === true) {
        showToaster = true;
      }
    }

    if (options.method === 'POST') {
      options.headers['Content-Type'] = 'application/json';
    }

    if (data) {
      options.body = JSON.stringify(data);
    }

    options.withCredentials = !headerParams.skipAuth;

    /*
        return this.httpClient.post<any>(url, hero, options)
          .pipe(
            catchError(this.handleError('addHero', hero))
          );*/


    return this.httpClient.request(options.method, url, options).pipe();
  }


  public post(conf: any, data?: Object): Observable<Object> {
    return this.request(conf.url, {method: 'POST'}, data, conf.headerParam)
      .pipe(response => {
        return this.responseHandler(response, conf.headerParam.showMessage);
      });
  }


  private responseHandler(response: any, showMessage: ShowMessageDto): any {
    // this.commons.hideLoading();
    if (response.status == 'FAILED' || response.status == 'PARTIAL_SUCCESS') {
      // this.commons.resetLoading();
      this.showErrorMessage(response);
      // this.commons.onApiError();
      throw response;
    } else {
      if (showMessage) {
        if (showMessage.showOnSuccessSearchWithResult) {
          this.alertService.showToaster(showMessage.successSearchResultMessage, SETTINGS.TOASTER_MESSAGES.success);
        }

        if (showMessage.showOnSuccessSearchEmptyResult) {
          if (response.result.pageData && response.result.pageData.length == 0) {
            this.alertService.showToaster(showMessage.successSearchEmptyResultMessage, SETTINGS.TOASTER_MESSAGES.warning, {duration: 3000});
          }
        }

        if (showMessage.showOnRecordSaveUpdate) {
          this.alertService.showToaster(showMessage.recordSaveUpdateMessage, SETTINGS.TOASTER_MESSAGES.success, {duration: 3000});
        }

        if (showMessage.showOnResourceSaveUpdate) {
          this.alertService.showToaster(showMessage.resourceSaveUpdateMessage, SETTINGS.TOASTER_MESSAGES.success, {duration: 3000});
        }

      }
    }
    if (!response.result) {
      return response;
    }
    return response.result;
  }

  private showErrorMessage(response: any) {
    let finalMessage = [];
    let alertType = response.status == 'FAILED' ? SETTINGS.TOASTER_MESSAGES.error : SETTINGS.TOASTER_MESSAGES.warning;

    response.appsErrorMessages.forEach((error) => {
      if (error.errorMessage != null) {
        finalMessage.push(error.errorMessage);
      }
    });

    this.alertService.showToaster(finalMessage.concat().toString(), alertType);
  }

}
