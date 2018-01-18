webpackJsonp([1,4],{

/***/ 1086:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(523);


/***/ }),

/***/ 254:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(240);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__ = __webpack_require__(273);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs__ = __webpack_require__(421);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EvenementService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var EvenementService = (function () {
    function EvenementService(http) {
        this.http = http;
        //private BACKEND_URL = 'http://192.168.1.15:8085';
        this.BACKEND_URL = 'http://localhost:8080';
        this.headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Headers */]({ 'Content-Type': 'application/json' });
        this.options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]({ headers: this.headers });
    }
    /*createEvenement(evenement) {
      let body = JSON.stringify(evenement);
      return this.http.post(this.BACKEND_URL+'/event/add_event/', body, this.options ).map((res: Response) => res.json());
    }*/
    EvenementService.prototype.getPlace = function () {
        return this.http.get(this.BACKEND_URL + '/place/list_place')
            .map(function (res) {
            var evenements = res.json();
            console.log(evenements);
            return evenements;
        });
    };
    EvenementService.prototype.extractData = function (res) {
        var body = res.json();
        console.log(body);
        return body;
    };
    EvenementService.prototype.handleError = function (error) {
        console.error(error.message || error);
        return __WEBPACK_IMPORTED_MODULE_3_rxjs__["Observable"].throw(error.status);
    };
    //Create article
    EvenementService.prototype.createEvenement = function (evenement) {
        return this.http.post(this.BACKEND_URL + '/event/saveEvent/', evenement, this.options)
            .map(function (success) { return success.status; })
            .catch(this.handleError);
    };
    //Fetch all institution by user
    EvenementService.prototype.getAllInstitutionByUser = function (idUser) {
        return this.http.get(this.BACKEND_URL + '/institution/list_institution_user/' + idUser)
            .map(this.extractData)
            .catch(this.handleError);
    };
    //Fetch all places
    EvenementService.prototype.getAllPlaces = function () {
        return this.http.get(this.BACKEND_URL + '/place/list_place')
            .map(this.extractData)
            .catch(this.handleError);
    };
    EvenementService.prototype.upload = function (fileToUpload) {
        var input = new FormData();
        input.append("file", fileToUpload);
        return this.http.post("/api/uploadFile", input);
    };
    EvenementService.prototype.fileChange = function (event) {
        var fileList = event.target.files;
        if (fileList.length > 0) {
            var file = fileList[0];
            var formData = new FormData();
            formData.append('uploadFile', file, file.name);
            var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Headers */]();
            headers.append('Accept', 'application/json');
            var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["c" /* RequestOptions */]({ headers: headers });
            this.http.post("/api/uploadFile", formData, options)
                .map(function (res) { return res.json(); })
                .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_3_rxjs__["Observable"].throw(error); })
                .subscribe(function (data) { return console.log('success'); }, function (error) { return console.log(error); });
        }
    };
    EvenementService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["c" /* Injectable */])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* Http */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* Http */]) === 'function' && _a) || Object])
    ], EvenementService);
    return EvenementService;
    var _a;
}());
//# sourceMappingURL=C:/spring/livindakar/livindakar/src/main/frontend/src/evenement.service.js.map

/***/ }),

/***/ 522:
/***/ (function(module, exports) {

function webpackEmptyContext(req) {
	throw new Error("Cannot find module '" + req + "'.");
}
webpackEmptyContext.keys = function() { return []; };
webpackEmptyContext.resolve = webpackEmptyContext;
module.exports = webpackEmptyContext;
webpackEmptyContext.id = 522;


/***/ }),

/***/ 523:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(609);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__environments_environment__ = __webpack_require__(644);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_app_module__ = __webpack_require__(641);




if (__WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].production) {
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_core__["a" /* enableProdMode */])();
}
__webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_3__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=C:/spring/livindakar/livindakar/src/main/frontend/src/main.js.map

/***/ }),

/***/ 640:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_service_evenement_service__ = __webpack_require__(254);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = (function () {
    /*evenementForm = new FormGroup({
       nom: new FormControl('', Validators.required),
       desc: new FormControl('', Validators.required),
       date: new FormControl('', Validators.required),
       heuredeb: new FormControl('', Validators.required),
       heurefin: new FormControl('', Validators.required),
       lieu: new FormControl(null, Validators.required),
       ins: new FormControl(null, Validators.required),
       photo: new FormControl('', Validators.required)
   });*/
    //title = 'app works!';
    function AppComponent(eventService) {
        this.eventService = eventService;
        this.requestProcessing = false;
        this.articleIdToUpdate = null;
        this.processValidation = false;
    }
    AppComponent.prototype.ngOnInit = function () {
        //this.getAllPlaces();
        //this.getAllInstitutionByUser();
    };
    AppComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-root',
            //templateUrl: './app.component.html',
            //styleUrls: ['./app.component.css']
            template: "\n  \t<div id=\"wrapper\">\n\t  \t<div id=\"header\">\n\t  \t\t<div class=\"logo-area clearfix\">\n\t\t\t\t<a href=\"#\" class=\"logo\"></a>\n\t\t\t</div>\n\n\t\t\t<!-- //logo-area-->\n\t\t\t\t\n\t\t\t<div class=\"tools-bar\">\n\t\t\t\t<ul class=\"nav navbar-nav nav-main-xs\">\n\t\t\t\t\t\t<li><a href=\"#menu\" class=\"icon-toolsbar\"><i class=\"fa fa-bars\"></i></a></li>\n\t\t\t\t</ul>\n\t\t\t\t<ul class=\"nav navbar-nav navbar-right tooltip-area\">\n\t\t\t\t\t<li><a href=\"#menu-right\" data-toggle=\"tooltip\" title=\"Right Menu\" data-container=\"body\" data-placement=\"left\"><i class=\"fa fa-align-right\"></i></a></li>\n\t\t\t\t\t<li class=\"hidden-xs hidden-sm\"><a href=\"#\" class=\"h-seperate\">Help</a></li>\n\t\t\t\t\t<li><button class=\"btn btn-circle btn-header-search\" ><i class=\"fa fa-search\"></i></button></li>\n\t\t\t\t\t<li><a href=\"#\" class=\"nav-collapse avatar-header\" data-toggle=\"tooltip\" title=\"Show / hide  menu\" data-container=\"body\" data-placement=\"bottom\">\n\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/img/avatar.png\"  class=\"circle\">\n\t\t\t\t\t\t\t\t\t<span class=\"badge\">3</span>\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"dropdown\">\n\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\">\n\t\t\t\t\t\t\t<em><strong>Hi</strong>, Nutprawee </em> <i class=\"dropdown-icon fa fa-angle-down\"></i>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t\t<ul class=\"dropdown-menu pull-right icon-right arrow\">\n\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-user\"></i> Profile</a></li>\n\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-cog\"></i> Setting </a></li>\n\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-bookmark\"></i> Bookmarks</a></li>\n\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-money\"></i> Make a Deposit</a></li>\n\t\t\t\t\t\t\t<li class=\"divider\"></li>\n\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-sign-out\"></i> Signout </a></li>\n\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t<!-- //dropdown-menu-->\n\t\t\t\t\t</li>\n\t\t\t\t\t<li class=\"visible-lg\">\n\t\t\t\t\t\t<a href=\"#\" class=\"h-seperate fullscreen\" data-toggle=\"tooltip\" title=\"Full Screen\" data-container=\"body\"  data-placement=\"left\">\n\t\t\t\t\t\t\t<i class=\"fa fa-expand\"></i>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t</li>\n\t\t\t\t</ul>\n\t\t\t</div>\n\t  \t</div>\n\n\t  \t<!-- //end header -->\n\n\t  \t<!-- //start nav -->\n\t  \t<div id=\"nav\">\n\t\t\t<div id=\"nav-scroll\">\n\t\t\t\t<div class=\"avatar-slide\">\n\t\t\t\t\n\t\t\t\t\t<span class=\"easy-chart avatar-chart\" data-color=\"theme-inverse\" data-percent=\"69\" data-track-color=\"rgba(255,255,255,0.1)\" data-line-width=\"5\" data-size=\"118\">\n\t\t\t\t\t\t\t<span class=\"percent\"></span>\n\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/img/avatar.png\" class=\"circle\">\n\t\t\t\t\t</span>\n\t\t\t\t\t<!-- //avatar-chart-->\n\t\t\t\t\t\n\t\t\t\t\t<div class=\"avatar-detail\">\n\t\t\t\t\t\t<p><strong>Hi</strong>, Nutprawee</p>\n\t\t\t\t\t\t<p><a href=\"#\">@ Chaing Mai , TH</a></p>\n\t\t\t\t\t\t<span>12,110 Sales</span>\n\t\t\t\t\t\t<span>106 Follower</span>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- //avatar-detail-->\n\t\t\t\t\t\n\t\t\t\t\t<div class=\"avatar-link btn-group btn-group-justified\">\n\t\t\t\t\t\t<a class=\"btn\" href=\"profile.html\"  title=\"Portfolio\"><i class=\"fa fa-briefcase\"></i></a>\n\t\t\t\t\t\t<a class=\"btn\"  data-toggle=\"modal\" href=\"#md-notification\" title=\"Notification\">\n\t\t\t\t\t\t\t\t<i class=\"fa fa-bell-o\"></i><em class=\"green\"></em>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t\t<a class=\"btn\"  data-toggle=\"modal\" href=\"#md-messages\"  title=\"Messages\">\n\t\t\t\t\t\t\t\t<i class=\"fa fa-envelope-o\"></i><em class=\"active\"></em>\n\t\t\t\t\t\t</a>\n\t\t\t\t\t\t<a class=\"btn\" href=\"#menu-right\" title=\"Contact List\"><i class=\"fa fa-book\"></i></a>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- //avatar-link-->\n\t\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<!-- //avatar-slide-->\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<div class=\"widget-collapse dark\">\n\t\t\t\t\t\t<header>\n\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" href=\"#collapseSummary\"><i class=\"collapse-caret fa fa-angle-up\"></i> Summary Order </a>\n\t\t\t\t\t\t</header>\n\t\t\t\t\t\t<section class=\"collapse in\" id=\"collapseSummary\">\n\t\t\t\t\t\t\t\t<div class=\"collapse-boby\" style=\"padding:0\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"widget-mini-chart align-xs-left\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pull-right\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"sparkline mini-chart\" data-type=\"bar\" data-color=\"warning\" data-bar-width=\"10\" data-height=\"35\">2,3,4,5,7,4,5</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<p>This week's balance</p>\n\t\t\t\t\t\t\t\t\t\t\t\t<h4>$12,788</h4>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- //widget-mini-chart -->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"widget-mini-chart align-xs-right\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pull-left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"sparkline mini-chart\" data-type=\"bar\" data-color=\"theme\" data-bar-width=\"10\" data-height=\"45\">2,3,7,5,4,6,6,3</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<p>This week sales</p>\n\t\t\t\t\t\t\t\t\t\t\t\t<h4>1,325 item</h4>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- //widget-mini-chart -->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- //collapse-boby-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</section>\n\t\t\t\t\t\t<!-- //collapse-->\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- //widget-collapse-->\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<div class=\"widget-collapse dark\">\n\t\t\t\t\t\t\t<header>\n\t\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" href=\"#collapseTasks\"><i class=\"collapse-caret fa fa-angle-down\"></i> (2) Tasks processing </a>\n\t\t\t\t\t\t\t</header>\n\t\t\t\t\t\t\t<section class=\"collapse\" id=\"collapseTasks\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div class=\"collapse-boby\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"widget-slider\">\n\t\t\t\t\t\t\t\t\t\t<p>Upload status</p>\n\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-dark progress-xs tooltip-in\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress-bar bg-darkorange\" aria-valuetransitiongoal=\"75\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<label class=\"progress-label\">Master.zip 4 / 5 </label>\n\t\t\t\t\t\t\t\t\t\t<!-- //progress-->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-dark progress-xs\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress-bar bg-theme-inverse\" aria-valuetransitiongoal=\"45\"></div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<label class=\"progress-label lasted\">Profile 2 / 5 </label>\n\t\t\t\t\t\t\t\t\t\t<!-- //progress-->\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<!-- //widget-slider-->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<!-- //collapse-boby-->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</section>\n\t\t\t\t\t\t\t<!-- //collapse-->\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- //widget-collapse-->\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<div class=\"widget-collapse dark\">\n\t\t\t\t\t\t<header>\n\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" href=\"#collapseSetting\"><i class=\"collapse-caret fa fa-angle-up\"></i> Setting Option </a>\n\t\t\t\t\t\t</header>\n\t\t\t\t\t\t<section class=\"collapse in\" id=\"collapseSetting\">\n\t\t\t\t\t\t\t<div class=\"collapse-boby\" style=\"padding:0\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<ul class=\"widget-slide-setting\">\n\t\t\t\t\t\t\t\t\t\t\t<li>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ios-switch theme pull-right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"switch\"><input type=\"checkbox\" name=\"option\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<label>Switch <span>OFF</span></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Lorem ipsum dolor sit amet</small>\n\t\t\t\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t\t\t\t<li>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ios-switch theme-inverse pull-right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"switch\"><input type=\"checkbox\" name=\"option_1\" checked></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<label>Switch <span>ON</span></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Lorem ipsum dolor sit amet</small>\n\t\t\t\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t\t\t\t<!-- //widget-slide-setting-->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<!-- //collapse-boby-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</section>\n\t\t\t\t\t\t<!-- //collapse-->\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- //widget-collapse-->\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t</div>\n\t\t\t\t<!-- //nav-scroller-->\n\t\t</div>\n\t\t<!-- //end nav-->\n\n\t\t<!-- //start main-->\n\n\t\t<div id=\"main\">\n\t\t\t<ol class=\"breadcrumb\">\n\t\t\t\t<li><a href=\"/evenement\">Home</a></li>\n\t\t\t\t<li><a href=\"#\">Library</a></li>\n\t\t\t\t<li class=\"active\">Data</li>\n\t\t\t</ol>\n\t\t\t<!-- //breadcrumb-->\n\n\t\t\t<!-- //start content-->\n\t\t\t<div id=\"content\">\n\t\t\t\t\n\t\t\t\t\t<!-- //section-->\n\t\t\t\t\t<section class=\"panel corner-flip\">\n\t\t\t\t\t\t<header class=\"panel-heading sm\" data-color=\"theme-inverse\">\n\t\t\t\t\t\t\t<h2><strong>Ajouter un \u00E9v\u00E9nement</strong></h2>\n\t\t\t\t\t\t\t<label class=\"color\"><strong><em></em></strong> </label>\n\t\t\t\t\t\t</header>\n\t\t\t\t\t\t<div class=\"panel-body\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</section>\n\t\t\t\t\t<!-- //section-->\n\t\t\t\t\n\t\t\t</div>\n\t\t\t<!-- //end content-->\n\t\t</div>\n\t\t<!-- //end main-->\n\t    \n\t </div> \n  \t<router-outlet></router-outlet>\n   \t"
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_service_evenement_service__["a" /* EvenementService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__shared_service_evenement_service__["a" /* EvenementService */]) === 'function' && _a) || Object])
    ], AppComponent);
    return AppComponent;
    var _a;
}());
//# sourceMappingURL=C:/spring/livindakar/livindakar/src/main/frontend/src/app.component.js.map

/***/ }),

/***/ 641:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(174);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__(354);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__(240);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_service_evenement_service__ = __webpack_require__(254);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_router__ = __webpack_require__(629);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_component__ = __webpack_require__(640);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__institution_institution_component__ = __webpack_require__(643);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__evenement_evenement_component__ = __webpack_require__(642);
/* unused harmony export appRoutes */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









//import { User } from 'app/classes/user';
var appRoutes = [
    { path: 'institution', component: __WEBPACK_IMPORTED_MODULE_7__institution_institution_component__["a" /* InstitutionComponent */] },
    { path: 'evenement', component: __WEBPACK_IMPORTED_MODULE_8__evenement_evenement_component__["a" /* EvenementComponent */] },
];
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_core__["b" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_7__institution_institution_component__["a" /* InstitutionComponent */],
                __WEBPACK_IMPORTED_MODULE_8__evenement_evenement_component__["a" /* EvenementComponent */],
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_http__["a" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["b" /* ReactiveFormsModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_router__["a" /* RouterModule */].forRoot(appRoutes)
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_4__shared_service_evenement_service__["a" /* EvenementService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */]]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
//# sourceMappingURL=C:/spring/livindakar/livindakar/src/main/frontend/src/app.module.js.map

/***/ }),

/***/ 642:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_service_evenement_service__ = __webpack_require__(254);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__(354);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__(240);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_map__ = __webpack_require__(273);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs__ = __webpack_require__(421);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_rxjs__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EvenementComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var EvenementComponent = (function () {
    function EvenementComponent(eventService, http) {
        this.eventService = eventService;
        this.http = http;
        this.requestProcessing = false;
        this.articleIdToUpdate = null;
        this.processValidation = false;
        //Create form
        this.evenementForm = new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormGroup */]({
            nom: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            desc: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            date: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            heuredeb: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            heurefin: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            lieu: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            place: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            ins: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            photo: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required)
        });
        this.valRech = true;
    }
    ;
    EvenementComponent.prototype.ngOnInit = function () {
        this.getAllPlaces();
        this.getAllInstitutionByUser();
    };
    //Fetch all places
    EvenementComponent.prototype.getAllPlaces = function () {
        var _this = this;
        this.eventService.getAllPlaces()
            .subscribe(function (data) {
            _this.allPlaces = data;
            console.log(_this.allPlaces);
        }, function (errorCode) {
            _this.statusCode = errorCode;
        });
    };
    EvenementComponent.prototype.getAllInstitutionByUser = function () {
        var _this = this;
        this.eventService.getAllInstitutionByUser(22)
            .subscribe(function (data) {
            _this.allInst = data;
            console.log(_this.allInst);
        }, function (errorCode) {
            _this.statusCode = errorCode;
        });
    };
    EvenementComponent.prototype.onEvenementFormSubmit = function () {
        this.processValidation = true;
        var datep = this.evenementForm.controls['lieu'].value;
        var inst = this.evenementForm.controls['ins'].value;
        console.log(this.idPlace);
        console.log(datep);
        /*if (this.evenementForm.invalid) {
            console.log("okkk no");
             return; //Validation failed, exit from method.
        }  */
        //Form is valid, now perform create or update
        //this.preProcessConfigurations();
        /*let nom = this.evenementForm.get('nom').value.trim();
        let desc = this.evenementForm.get('desc').value.trim();
        let date = this.evenementForm.get('date').value.trim();
        let heuredeb = this.evenementForm.get('heuredeb').value.trim();
        let heurefin = this.evenementForm.get('heurefin').value.trim();
        let lieu = this.evenementForm.get('lieu').value.trim();
        let place = this.evenementForm.get('place').value.trim();
        let ins = this.evenementForm.get('ins').value.trim();
        let photo = this.evenementForm.get('photo').value.trim();
        //Handle create article
        let evenement= new Evenement(null, nom, desc,date,heuredeb,heurefin,this.idPlace,ins,photo,1,4);
        console.log(evenement);
        this.eventService.createEvenement(evenement)
          .subscribe(successCode => {
                  this.statusCode = successCode;
                  console.log(successCode);
              
            },
              errorCode => this.statusCode = errorCode); */
    };
    //Perform preliminary processing configurations
    EvenementComponent.prototype.preProcessConfigurations = function () {
        this.statusCode = null;
        this.requestProcessing = true;
    };
    //Go back from update to create
    EvenementComponent.prototype.backToCreateArticle = function () {
        this.articleIdToUpdate = null;
        this.evenementForm.reset();
        this.processValidation = false;
    };
    EvenementComponent.prototype.onChange = function (files) {
        console.log(files);
    };
    EvenementComponent.prototype.getItemsPlaces = function (ev) {
        // Reset items back to all of the items
        this.valRech = false;
        console.log(this.valRech);
        // set val to the value of the searchbar
        var val = ev.target.value;
        console.log(val);
        // if the value is an empty string don't filter the items
        if (val && val.trim() != '') {
            this.lPlaces = this.allPlaces.filter(function (item) {
                return (item.nomPlace.toLowerCase().indexOf(val.toLowerCase()) > -1);
            });
        }
        if (val == '' || !val) {
            this.lPlaces = this.allPlaces;
        }
        console.log(this.lPlaces);
        console.log(this.allPlaces);
    };
    EvenementComponent.prototype.chooseItem = function (tag) {
        var _this = this;
        this.place = this.allPlaces.filter(function (item) {
            console.log(item.idPlace);
            _this.idPlace = +item.idPlace;
            _this.valRech = false;
            _this.evenementForm.controls['place'].setValue(tag.nomPlace);
            return (item.nomPlace.toLowerCase().indexOf(tag.nomPlace.toLowerCase()) > -1);
        });
        //this.viewCtrl.dismiss(this.insRecherche);
    };
    EvenementComponent.prototype.addFile = function () {
        var fi = this.fileInput.nativeElement;
        if (fi.files && fi.files[0]) {
            var fileToUpload = fi.files[0];
            this.eventService
                .upload(fileToUpload)
                .subscribe(function (res) {
                console.log(res);
            });
        }
    };
    EvenementComponent.prototype.fileChange = function (event) {
        var fileList = event.target.files;
        if (fileList.length > 0) {
            var file = fileList[0];
            var formData = new FormData();
            formData.append('uploadFile', file, file.name);
            var headers = new __WEBPACK_IMPORTED_MODULE_3__angular_http__["b" /* Headers */]();
            headers.append('Accept', 'application/json');
            var options = new __WEBPACK_IMPORTED_MODULE_3__angular_http__["c" /* RequestOptions */]({ headers: headers });
            this.http.post("/institution/upload", formData, options)
                .map(function (res) { return res.json(); })
                .catch(function (error) { return __WEBPACK_IMPORTED_MODULE_5_rxjs__["Observable"].throw(error); })
                .subscribe(function (data) { return console.log('success'); }, function (error) { return console.log(error); });
        }
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_7" /* ViewChild */])("fileInput"), 
        __metadata('design:type', Object)
    ], EvenementComponent.prototype, "fileInput", void 0);
    EvenementComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-evenement',
            template: __webpack_require__(801),
            styles: [__webpack_require__(799)]
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_service_evenement_service__["a" /* EvenementService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__shared_service_evenement_service__["a" /* EvenementService */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_http__["d" /* Http */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__angular_http__["d" /* Http */]) === 'function' && _b) || Object])
    ], EvenementComponent);
    return EvenementComponent;
    var _a, _b;
}());
//# sourceMappingURL=C:/spring/livindakar/livindakar/src/main/frontend/src/evenement.component.js.map

/***/ }),

/***/ 643:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(1);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InstitutionComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var InstitutionComponent = (function () {
    function InstitutionComponent() {
    }
    InstitutionComponent.prototype.ngOnInit = function () {
    };
    InstitutionComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_6" /* Component */])({
            selector: 'app-institution',
            template: __webpack_require__(802),
            styles: [__webpack_require__(800)]
        }), 
        __metadata('design:paramtypes', [])
    ], InstitutionComponent);
    return InstitutionComponent;
}());
//# sourceMappingURL=C:/spring/livindakar/livindakar/src/main/frontend/src/institution.component.js.map

/***/ }),

/***/ 644:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.
var environment = {
    production: false
};
//# sourceMappingURL=C:/spring/livindakar/livindakar/src/main/frontend/src/environment.js.map

/***/ }),

/***/ 799:
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ 800:
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ 801:
/***/ (function(module, exports) {

module.exports = " \t <div id=\"wrapper\">\r\n\t\t<!--\r\n\t\t/////////////////////////////////////////////////////////////////////////\r\n\t\t//////////     HEADER  CONTENT     ///////////////\r\n\t\t//////////////////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<div id=\"header\">\r\n\t\t\r\n\t\t\t\t<div class=\"logo-area clearfix\">\r\n\t\t\t\t\t\t<a href=\"#\" class=\"logo\"> LIV'IN DKR</a>\r\n\t\t\t\t</div>\r\n\t\t\t\t<!-- //logo-area-->\r\n\t\t\t\t\r\n\t\t\t\t<div class=\"tools-bar\">\r\n\t\t\t\t\t\t<ul class=\"nav navbar-nav nav-main-xs\">\r\n\t\t\t\t\t\t\t\t<li><a href=\"#menu\" class=\"icon-toolsbar\"><i class=\"fa fa-bars\"></i></a></li>\r\n\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right tooltip-area\">\r\n\t\t\t\t\t\t\t\t<li><a href=\"#menu-right\" data-toggle=\"tooltip\" title=\"Right Menu\" data-container=\"body\" data-placement=\"left\"><i class=\"fa fa-align-right\"></i></a></li>\r\n\t\t\t\t\t\t\t\t<li class=\"hidden-xs hidden-sm\"><a href=\"#\" class=\"h-seperate\">Aide</a></li>\r\n\t\t\t\t\t\t\t\t<li><button class=\"btn btn-circle btn-header-search\" ><i class=\"fa fa-search\"></i></button></li>\r\n\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"nav-collapse avatar-header\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/img/profil.jpg\"  class=\"circle\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"badge\">3</span>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t<li class=\"dropdown\">\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" data-hover=\"dropdown\">\r\n\t\t\t\t\t\t\t\t\t\t\t<em><strong></strong> Admin Liv'in DKR </em> <i class=\"dropdown-icon fa fa-angle-down\"></i>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu pull-right icon-right arrow\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-user\"></i> Profile</a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-cog\"></i> Setting </a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-bookmark\"></i> Bookmarks</a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-money\"></i> Make a Deposit</a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-sign-out\"></i> Signout </a></li>\r\n\t\t\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t\t\t\t<!-- //dropdown-menu-->\r\n\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t<li class=\"visible-lg\">\r\n\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"h-seperate fullscreen\" data-toggle=\"tooltip\" title=\"Full Screen\" data-container=\"body\"  data-placement=\"left\">\r\n\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-expand\"></i>\r\n\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t</ul>\r\n\t\t\t\t</div>\r\n\t\t\t\t<!-- //tools-bar-->\r\n\t\t\t\t\r\n\t\t</div>\r\n\t\t<!-- //header-->\r\n\t\t\r\n\t\t\r\n\t\t<!--\r\n\t\t/////////////////////////////////////////////////////////////////////////\r\n\t\t//////////     SLIDE LEFT CONTENT     //////////\r\n\t\t//////////////////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<div id=\"nav\">\r\n\t\t\t\t<div id=\"nav-scroll\">\r\n\t\t\t\t\t\t<div class=\"avatar-slide\">\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<span class=\"easy-chart avatar-chart\" data-color=\"theme-inverse\" data-percent=\"69\" data-track-color=\"rgba(255,255,255,0.1)\" data-line-width=\"5\" data-size=\"118\">\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"percent\"></span>\r\n\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/img/profil.jpg\" class=\"circle\">\r\n\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t<!-- //avatar-chart-->\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<div class=\"avatar-detail\">\r\n\t\t\t\t\t\t\t\t\t\t<p><strong>Admin</strong> Liv'in DKR</p>\r\n\t\t\t\t\t\t\t\t\t\t<p><a href=\"#\">@ admin</a></p>\r\n\t\t\t\t\t\t\t\t\t\t<span>12,110 Institutions</span>\r\n\t\t\t\t\t\t\t\t\t\t<span>106 Evénements</span>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<!-- //avatar-detail-->\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<div class=\"avatar-link btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t<a class=\"btn\" href=\"profile.html\"  title=\"Portfolio\"><i class=\"fa fa-briefcase\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t<a class=\"btn\"  data-toggle=\"modal\" href=\"#md-notification\" title=\"Notification\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-bell-o\"></i><em class=\"green\"></em>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t<a class=\"btn\"  data-toggle=\"modal\" href=\"#md-messages\"  title=\"Messages\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-envelope-o\"></i><em class=\"active\"></em>\r\n\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t<a class=\"btn\" href=\"#menu-right\" title=\"Contact List\"><i class=\"fa fa-book\"></i></a>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<!-- //avatar-link-->\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<!-- //avatar-slide-->\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<div class=\"widget-collapse dark\">\r\n\t\t\t\t\t\t\t\t<header>\r\n\t\t\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" href=\"#collapseSummary\"><i class=\"collapse-caret fa fa-angle-up\"></i> Historiques hebdomadaires </a>\r\n\t\t\t\t\t\t\t\t</header>\r\n\t\t\t\t\t\t\t\t<section class=\"collapse in\" id=\"collapseSummary\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"collapse-boby\" style=\"padding:0\">\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-mini-chart align-xs-left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pull-right\" >\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"sparkline mini-chart\" data-type=\"bar\" data-color=\"theme\" data-bar-width=\"10\" data-height=\"35\">2,3,4,5,7,4,5</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>Institutions</p>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4>120</h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- //widget-mini-chart -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-mini-chart align-xs-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pull-left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"sparkline mini-chart\" data-type=\"bar\" data-color=\"warning\" data-bar-width=\"10\" data-height=\"45\">2,3,7,5,4,6,6,3</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>Evénements</p>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4>100 </h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- //widget-mini-chart -->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t<!-- //collapse-boby-->\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t<!-- //collapse-->\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<!-- //widget-collapse-->\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t<!--\t\r\n\t\t\t\t\t\t<div class=\"widget-collapse dark\">\r\n\t\t\t\t\t\t\t\t<header>\r\n\t\t\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" href=\"#collapseTasks\"><i class=\"collapse-caret fa fa-angle-down\"></i> (2) Tasks processing </a>\r\n\t\t\t\t\t\t\t\t</header>\r\n\t\t\t\t\t\t\t\t<section class=\"collapse\" id=\"collapseTasks\">\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"collapse-boby\">\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-slider\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>Upload status</p>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-dark progress-xs tooltip-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress-bar bg-darkorange\" aria-valuetransitiongoal=\"75\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"progress-label\">Master.zip 4 / 5 </label>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- //progress-->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-dark progress-xs\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress-bar bg-theme-inverse\" aria-valuetransitiongoal=\"45\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"progress-label lasted\">Profile 2 / 5 </label>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- //progress-->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!--</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- //widget-slider-->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<!--</div>\r\n\t\t\t\t\t\t\t\t\t\t<!-- //collapse-boby-->\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<!--</section>\r\n\t\t\t\t\t\t\t\t<!-- //collapse-->\r\n\t\t\t\t\t\t<!--</div>\r\n\t\t\t\t\t-->\r\n\t\t\t\t\t\t<!-- //widget-collapse-->\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<!--\r\n\t\t\t\t\t\t<div class=\"widget-collapse dark\">\r\n\t\t\t\t\t\t\t\t<header>\r\n\t\t\t\t\t\t\t\t\t\t<a data-toggle=\"collapse\" href=\"#collapseSetting\"><i class=\"collapse-caret fa fa-angle-up\"></i> Setting Option </a>\r\n\t\t\t\t\t\t\t\t</header>\r\n\t\t\t\t\t\t\t\t<section class=\"collapse in\" id=\"collapseSetting\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"collapse-boby\" style=\"padding:0\">\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"widget-slide-setting\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ios-switch theme pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"switch\"><input type=\"checkbox\" name=\"option\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>Switch <span>OFF</span></label>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Lorem ipsum dolor sit amet</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ios-switch theme-inverse pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"switch\"><input type=\"checkbox\" name=\"option_1\" checked></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>Switch <span>ON</span></label>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Lorem ipsum dolor sit amet</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- //widget-slide-setting-->\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t<!--</div>\r\n\t\t\t\t\t\t\t\t\t\t<!-- //collapse-boby-->\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<!--</section>\r\n\t\t\t\t\t\t\t\t<!-- //collapse-->\r\n\t\t\t\t\t\t<!--</div>\r\n\t\t\t\t\t\t-->\r\n\t\t\t\t\t\t<!-- //widget-collapse-->\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t</div>\r\n\t\t\t\t<!-- //nav-scroller-->\r\n\t\t</div>\r\n\t\t<!-- //nav-->\r\n\t\t\r\n\t\t\r\n\t\t<!--\r\n\t\t/////////////////////////////////////////////////////////////////////////\r\n\t\t//////////     TOP SEARCH CONTENT     ///////\r\n\t\t//////////////////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<div class=\"widget-top-search\">\r\n\t\t\t<span class=\"icon\"><a href=\"#\" class=\"close-header-search\"><i class=\"fa fa-times\"></i></a></span>\r\n\t\t\t<form id=\"top-search\">\r\n\t\t\t\t\t<h2><strong>Quick</strong> Search</h2>\r\n\t\t\t\t\t<div class=\"input-group\">\r\n\t\t\t\t\t\t\t<input  type=\"text\" name=\"q\" placeholder=\"Find something...\" class=\"form-control\" />\r\n\t\t\t\t\t\t\t<span class=\"input-group-btn\">\r\n\t\t\t\t\t\t\t<button class=\"btn\" type=\"button\" title=\"With Sound\"><i class=\"fa fa-microphone\"></i></button>\r\n\t\t\t\t\t\t\t<button class=\"btn\" type=\"button\" title=\"Visual Keyboard\"><i class=\"fa fa-keyboard-o\"></i></button>\r\n\t\t\t\t\t\t\t<button class=\"btn\" type=\"button\" title=\"Advance Search\"><i class=\"fa fa-th\"></i></button>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t</form>\r\n\t\t</div>\r\n\t\t<!-- //widget-top-search-->\r\n\t\t\r\n\t\t\r\n\r\n\t\t\r\n\t\t<!--\r\n\t\t/////////////////////////////////////////////////////////////////////////\r\n\t\t//////////     MAIN SHOW CONTENT     //////////\r\n\t\t//////////////////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<div id=\"main\">\r\n\t\t\t\t<div class=\"tabbable\">\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<div class=\"tab-content\">\r\n\t\t\t\t\t\t\t\t<!--div class=\"col-lg-6\"-->\r\n        \t\t\t\t<section class=\"panel corner-flip\">\r\n\t\t\t\t\t\t<header class=\"panel-heading sm\" data-color=\"theme-inverse\">\r\n\t\t\t\t\t\t\t<h2><strong>Ajouter un événement</strong></h2>\r\n\t\t\t\t\t\t\t<label class=\"color\"><strong><em></em></strong> </label>\r\n\r\n\t\t\t\t\t\t</header>\r\n\t\t\t\t\t\t<div class=\"panel-body\">\r\n\r\n\t\t\t\t\t\t\t<form [formGroup]=\"evenementForm\" class=\"form-horizontal\" (ngSubmit)=\"onEvenementFormSubmit()\">\r\n\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Nom</label>\r\n\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" formControlName=\"nom\" >\r\n\t\t\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('nom').invalid && processValidation\" [ngClass] = \"'error'\"> Le nom est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Description</label>\r\n\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"3\" data-height=\"auto\" placeholder=\"\" formControlName=\"desc\" ></textarea>\r\n\t\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('desc').invalid && processValidation\" [ngClass] = \"'error'\"> La description est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\r\n\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<div  class=\"form-group\">\r\n\t\t\t\t\t\t\t\t<label class=\"control-label\">Date</label>\r\n\t\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"input-group date form_datetime col-lg-6\" data-picker-position=\"bottom-left\"  data-date-format=\"dd MM yyyy - HH:ii p\" >\r\n\t\t\t\t\t\t\t\t\t\t\t<input  class=\"form-control\" formControlName=\"date\">\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"input-group-btn\">\r\n\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\"><i class=\"fa fa-times\"></i></button>\r\n\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\"><i class=\"fa fa-calendar\"></i></button>\r\n\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('date').invalid && processValidation\" [ngClass] = \"'error'\"> La date est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Heure de debut</label>\r\n\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t<input  class=\"form-control\"formControlName=\"heuredeb\" >\r\n\t\t\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('heuredeb').invalid && processValidation\" [ngClass] = \"'error'\"> L'heure de debut est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Heure Fin</label>\r\n\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t<input  class=\"form-control\"formControlName=\"heurefin\">\r\n\t\t\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('heurefin').invalid && processValidation\" [ngClass] = \"'error'\"> L'heure de fin est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Place</label>\r\n\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t<input #myPlace class=\"form-control\"formControlName=\"place\" (input)=\"getItemsPlaces($event)\">\r\n\t\t\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('place').invalid && processValidation\" [ngClass] = \"'error'\"> La place est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t<div class=\"col-md-12\">\r\n\t\t\t\t\t\t\t  <table class=\"table table-responsive table-hover\" style=\"margin-left: 90px; width: 88%;\">\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t    <tr *ngFor=\"let item of lPlaces\" (click)=\"chooseItem(item)\">\r\n\t\t\t\t\t\t\t      \r\n\t\t\t\t\t\t\t      <td>{{item.nomPlace}}</td>\r\n\t\t\t\t\t\t\t      \r\n\t\t\t\t\t\t\t    </tr>\r\n\t\t\t\t\t\t\t  </table>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t<label class=\"control-label\">Lieu</label>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n\t\t\t\t\t\t\t\t\t<select  class=\"form-control\" formControlName=\"lieu\">\r\n\t\t\t\t\t\t\t\t\t\t<option *ngFor=\"let place of allPlaces\"  [ngValue]=\"place.idPlace\">\r\n\t\t\t\t\t\t\t\t\t\t\t{{place.nomPlace}}\r\n\t\t\t\t\t\t\t\t\t\t</option>\r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('lieu').invalid && processValidation\" [ngClass] = \"'error'\"> Le lieu est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t<label class=\"control-label\">Institution</label>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n\t\t\t\t\t\t\t\t\t<select  class=\"form-control\" formControlName=\"ins\" >\r\n\t\t\t\t\t\t\t\t\t\t<option *ngFor=\"let inst of allInst\" [ngValue]=\"inst.idInstitution\">\r\n\t\t\t\t\t\t\t\t\t\t\t{{inst.nomIns}}\r\n\t\t\t\t\t\t\t\t\t\t</option>\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('ins').invalid && processValidation\" [ngClass] = \"'error'\"> L'institution est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\r\n\r\n\t\t\t\t\t\t\t<div class=\"form-group\">\r\n\t\t\t\t\t\t\t\t\t<label class=\"control-label\" for=\"exampleInputFile\" >Photo</label>\r\n\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"file\" id=\"exampleInputFile\" formControlName=\"photo\" (change)=\"fileChange($event)\">\r\n\t\t\t\t\t\t\t\t\t\t\t<!--button (click)=\"addFile()\">Add</button-->\r\n\t\t\t\t\t\t\t\t\t\t\t<label *ngIf=\"evenementForm.get('photo').invalid && processValidation\" [ngClass] = \"'error'\"> La photo est obligatoire. </label>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"form-group offset\">\r\n\t\t\t\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-theme\">Submit</button>\r\n\t\t\t\t\t\t\t\t\t\t\t<button type=\"reset\" class=\"btn\">Cancel</button>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</form>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</section>\r\n\t\t\t\t\t<!-- //section-->\r\n\t\t</div>\r\n\t\t<!-- //modal-->\r\n\r\n\r\n\t\t<!--\r\n\t\t///////////////////////////////////////////////////////////////////\r\n\t\t//////////     MODAL MESSAGES     //////////\r\n\t\t///////////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<div id=\"md-messages\" class=\"modal fade md-slideUp bg-theme-inverse\" tabindex=\"-1\" data-width=\"450\">\r\n\t\t\t\t<div class=\"modal-header bd-theme-inverse-darken\">\r\n\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\"><i class=\"fa fa-times\"></i></button>\r\n\t\t\t\t\t\t<h4 class=\"modal-title\"><i class=\"fa fa-inbox\"></i> Inbox messages</h4>\r\n\t\t\t\t</div>\r\n\t\t\t\t<!-- //modal-header-->\r\n\t\t\t\t<div class=\"modal-body\" style=\"padding:0\">\r\n\t\t\t\t\t\t<div class=\"widget-im\">\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<section  class=\"thumbnail-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-im-tools tooltip-area pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-paperclip\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-reply-all\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"im-delete\" data-toggle=\"tooltip\" title=\"Delete\"><i class=\"fa fa-trash-o\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<time datetime=\"2013-11-16\">1 : 52 am</time>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4><a href=\"javascript:void(0)\">Edlado Holder</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-thumbnail\"><img alt=\"\" src=\"assets/img/avatar2.png\" /></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label></label>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pre-text\"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-confirm-group\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-inverse im-confirm\" href=\"javascript:void(0)\" data-confirm=\"yes\">YES.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-theme im-confirm\" href=\"javascript:void(0)\" data-confirm=\"no\">NO.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<section  class=\"thumbnail-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-im-tools tooltip-area pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-paperclip\"></i>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"im-delete\" data-toggle=\"tooltip\" title=\"Delete\"><i class=\"fa fa-trash-o\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<time datetime=\"2013-11-16\">12 : 00 pm</time>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4><a href=\"javascript:void(0)\">Laine Franchi</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-thumbnail\"><i class=\"glyphicon glyphicon-user\"></i></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pre-text\"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-confirm-group\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-inverse im-confirm\" href=\"javascript:void(0)\" data-confirm=\"yes\">YES.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-theme im-confirm\" href=\"javascript:void(0)\" data-confirm=\"no\">NO.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<section class=\"thumbnail-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-im-tools tooltip-area pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"im-delete\" data-toggle=\"tooltip\" title=\"Delete\"><i class=\"fa fa-trash-o\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<time datetime=\"2013-11-16\">4 : 45 pm</time>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4><a href=\"javascript:void(0)\">Cinda Collar</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-thumbnail\"><img alt=\"\" src=\"assets/img/avatar.png\" /></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label data-color=\"theme\"></label>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pre-text\"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-confirm-group\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-inverse im-confirm\" href=\"javascript:void(0)\" data-confirm=\"yes\">YES.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-theme im-confirm\" href=\"javascript:void(0)\" data-confirm=\"no\">NO.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t\t<button class=\"btn btn-inverse btn-block btn-lg\" title=\"See More\"><i class=\"fa fa-plus\"></i></button>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<!-- //widget-im-->\r\n\t\t\t\t</div>\r\n\t\t\t\t<!-- //modal-body-->\r\n\t\t</div>\r\n\t\t<!-- //modal-->\r\n\t\t\r\n\t\t\r\n\t\t\r\n\t\t<!--\r\n\t\t//////////////////////////////////////////////////////////////////////////\r\n\t\t//////////     MODAL NOTIFICATION     //////////\r\n\t\t//////////////////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<div id=\"md-notification\" class=\"modal fade md-stickTop bg-danger\" tabindex=\"-1\" data-width=\"500\">\r\n\t\t\t\t<div class=\"modal-header bd-danger-darken\">\r\n\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\"><i class=\"fa fa-times\"></i></button>\r\n\t\t\t\t\t\t<h4 class=\"modal-title\"><i class=\"fa fa-bell-o\"></i> Notification</h4>\r\n\t\t\t\t</div>\r\n\t\t\t\t<!-- //modal-header-->\r\n\t\t\t\t<div class=\"modal-body\" style=\"padding:0\">\r\n\t\t\t\t\t\t<div class=\"widget-im notification\">\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<section class=\"thumbnail-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-im-tools tooltip-area pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<time class=\"timeago lasted\" datetime=\"2014\">when you opened the page</time>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"im-action\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Action\"><i class=\"fa fa-keyboard-o\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4>Your request approved</h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-thumbnail bg-theme-inverse\"><i class=\"fa fa-check\"></i></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pre-text\">One Button (click to remove this)</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-confirm-group\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-inverse im-confirm\" href=\"javascript:void(0)\" data-confirm=\"accept\">Accept.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<section class=\"thumbnail-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-im-tools tooltip-area pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<time class=\"timeago\" datetime=\"2013-11-17T14:24:17Z\">timeago</time>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"im-action\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Action\"><i class=\"fa fa-keyboard-o\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4>Dashboard new design!! you want to see now ? </h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-thumbnail bg-theme\"><i class=\"fa fa-bell-o\"></i></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pre-text\">Two Button (with link and click to close this) Lorem ipsum dolor sit amet, consectetur adipisicing elit, </div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-confirm-group\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-inverse\" href=\"dashboard.html\">Go Now.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-theme im-confirm\" href=\"javascript:void(0)\" data-confirm=\"no\">Later.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<section class=\"thumbnail-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-im-tools tooltip-area pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<time class=\"timeago\" datetime=\"2013-11-17T01:24:17Z\">timeago</time>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"im-action\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Action\"><i class=\"fa fa-keyboard-o\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4>Error 404 <small>( File not  found )</small></h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-thumbnail bg-warning\"><i class=\"fa fa-exclamation-triangle\"></i></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pre-text\">Two Button (click to  action and remove) </div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-confirm-group\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-inverse im-confirm\" href=\"javascript:void(0)\" data-confirm=\"accept\">Accept.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-theme im-confirm\" href=\"javascript:void(0)\" data-confirm=\"actionNow\">Fixed now.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<section class=\"thumbnail-in\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"widget-im-tools tooltip-area pull-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<time class=\"timeago\" datetime=\"2013-09-17T09:24:17Z\">timeago</time>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"im-action\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Action\"><i class=\"fa fa-keyboard-o\"></i></a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h4>Upgrade Premium ?</h4>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-thumbnail bg-inverse\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-cogs\"></i></div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"pre-text\"> Three button (test action) </div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</section>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"im-confirm-group\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" btn-group btn-group-justified\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-inverse im-confirm\" href=\"javascript:void(0)\" data-confirm=\"actionNow\">Now.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-theme im-confirm\" href=\"javascript:void(0)\" data-confirm=\"no\">Later.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"btn btn-danger im-confirm\" href=\"javascript:void(0)\" data-confirm=\"yes\">Delete.</a>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t<!-- //widget-im-->\r\n\t\t\t\t</div>\r\n\t\t\t\t<!-- //modal-body-->\r\n\t\t</div>\r\n\t\t<!-- //modal-->\r\n\t\t\r\n\t\t\r\n\t\t\r\n\t\t<!--\r\n\t\t//////////////////////////////////////////////////////////////\r\n\t\t//////////     LEFT NAV MENU     //////////\r\n\t\t///////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<nav id=\"menu\">\r\n\t\t\t\t<ul>\r\n\t\t\t\t\t\t<li><span><i class=\"icon  fa fa-laptop\"></i> Dashboard</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"dashboard.html\"><i class=\"icon  fa fa-rocket\"></i> First Design </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"dashboard2.html\"><i class=\"icon  fa fa-th\"></i> Dashboard New </a></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<!-- \r\n\t\t\t\t\t\t<li><a href=\"front/index.html\"><i class=\"icon  fa fa-rocket\"></i> Front End </a></li>\r\n\t\t\t\t\t\t<li><span><i class=\"icon  fa fa-th-list\"></i> Layout</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label label-lg\">Main Layout</li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"alwayMenu.html\"> Alway Left  Menu </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"hideUserPanel.html\"> Hide User Panel </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"hideUserPanelIn.html\"> Show & Hide</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label label-lg\">Other Layout</li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"topMenu.html\"> Top Menu</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"footerShow.html\"> Footer Show</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"footerMenu.html\"> Footer with menu</a></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\r\n\t\t\t\t\t\t<li><a href=\"mailBox.html\"><i class=\"icon  fa fa-inbox\"></i> Mail</a></li>\r\n\r\n\t\t\t\t\t\t-->\r\n\t\t\t\t\t\t<li><span><i class=\"icon  fa fa-briefcase\"></i> UI Element</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui.html\"> UI </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_button.html\"> Button </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_icon.html\"> Fonts Icon</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_slide.html\"> Slide</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_modal.html\"> Modal</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_panel.html\"> Panel</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_alert.html\"> Alert</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_typography.html\"> Typography</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"ui_nestable.html\"> Nestable</a></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<!--\r\n\t\t\t\t\t\t<li><span><i class=\"icon  fa fa-bar-chart-o\"></i> Chart </span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"chartFlot.html\"> Flot Chart</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"chartMorris.html\"> Morris Chart</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"chartOther.html\"> Other Chart</a></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t-->\r\n\t\t\t\t\t\t<li><a href=\"calendar.html\"><i class=\"icon  fa fa-calendar-o\"></i> Calendar </a></li>\r\n\t\t\t\t\t\t<li><a class=\"mm-subopen mm-fullsubopen\" href=\"#mm-m1-p4\"></a><span><i class=\"icon  fa fa-bar-chart-o\"></i> Chart </span>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</li>\r\n\r\n\t\t\t\t\t\t<!-- <li><a href=\"mailBox.html\"><i class=\"icon  fa fa-inbox\"></i> Mail</a></li> -->\r\n\t\t\t\t\t\t<li><a href=\"mailBox.html\"><i class=\"icon  fa fa-envelope\"></i> Mail</a></li>\r\n\r\n\t\t\t\t\t\t<!-- <li><span><i class=\"icon  fa fa-align-right\"></i>Off  Canvas  Menu</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"menu.html\"> Position </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"menuOpen.html\"> Touch to open</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"menuVertical.html\"> Vertical Level</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><span> Unlimited Level </span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"> Level 3 </a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"> Level 3 </a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span> Level 4</span>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"> Level 4 </a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\"> Level 4 </a></li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t\t\t-->\r\n\r\n\t\t\t\t\t\t<!-- \r\n\t\t\t\t\t\t<li><span><i class=\"icon  fa fa-clipboard\"></i> From</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"form.html\">Form Basic</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"formComponents.html\">Form Components</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"formValidate.html\">Form Validate</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"formWizard.html\">Form Wizard</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"formMutiselect.html\">Form Mutiseletion</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"form_x_edit.html\">Form x-edit</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"drop_upload.html\">Drop Upload</a></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li><a href=\"fileManager.html\"><i class=\"icon  fa fa-file-text\"></i> File Manager </a></li>\r\n\t\t\t\t\t\t<li><span><i class=\"icon  fa fa-fire\"></i> Table</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"table.html\">Table Basic</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"tableResponsive.html\">Table Responsive</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"tableDynamic.html\">Data Table</a></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li><span><i class=\"icon  fa fa-folder-open-o\"></i> Other Page</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"login.html\"> login </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"lockscreen.html\"> Lockscreen </a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"images_manager.html\"> Images Manager</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"gallery.html\"> Gallery</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"timeline.html\"> Timeline</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"profile.html\"> Profile</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"blankPage.html\"> Blank Page</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"page_invoice.html\"> Invoice</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"page_search.html\"> Search result</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"pages_pricing.html\"> Pricing Table</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"register.html\"> Register</a></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><a href=\"page_chat.html\"> Full Chat</a></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li><a href=\"map.html\"><i class=\"icon  fa fa-map-marker\"></i> Maps</a></li>\r\n\t\t\t\t\t\t<li><a href=\"404.html\"><i class=\"icon  fa fa-exclamation-triangle\"></i> Error Pages</a></li>\r\n\t\t\t\t\t\t<li><a href=\"siteMap.html\"><i class=\"icon  fa fa-sitemap\"></i>Site Map</a></li>\r\n\t\t\t\t\t\t-->\r\n\t\t\t\t</ul>\r\n\t\t</nav>\r\n\t\t<!-- //nav left menu-->\r\n\t\t\r\n\t\t\r\n\t\t\r\n\t\t<!--\r\n\t\t/////////////////////////////////////////////////////////////////\r\n\t\t//////////     RIGHT NAV MENU     //////////\r\n\t\t/////////////////////////////////////////////////////////////\r\n\t\t-->\r\n\t\t<nav id=\"menu-right\">\r\n\t\t\t\t<ul>\r\n\t\t\t\t\t\t<li class=\"Label label-lg\">Theme color</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t<span class=\"text-center\">\r\n\t\t\t\t\t\t\t\t<div id=\"style1\" class=\"color-themes col1\"></div>\r\n\t\t\t\t\t\t\t\t<div id=\"style2\" class=\"color-themes col2\" ></div>\r\n\t\t\t\t\t\t\t\t<div id=\"style3\" class=\"color-themes col3\" ></div>\r\n\t\t\t\t\t\t\t\t<div id=\"style4\" class=\"color-themes col4\" ></div>\r\n\t\t\t\t\t\t\t\t<div id=\"none\" class=\"color-themes col5\" ></div>\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"Label label-lg\">Contact Group</li>\r\n\t\t\t\t\t\t<li data-counter-color=\"theme\">\r\n\t\t\t\t\t\t\t\t<span><i class=\"icon fa fa-smile-o\"></i> Friends</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">A</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/1.jpg\" /> Alexa \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Johnson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"busy\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/2.jpg\" /> Alexander \r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Brown</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">F</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/3.jpg\" /> Fred\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Smith</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">J</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/4.jpg\" /> James\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Miller</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/5.jpg\" /> Jefferson\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Jackson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/6.jpg\" /> Jordan\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Lee</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">K</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/7.jpg\" /> Kim\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Adams</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">M</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/8.jpg\" /> Meagan\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Miller</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"busy\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/9.jpg\" /> Melissa\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Johnson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">N</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/10.jpg\" /> Nicole\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Smith</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">S</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/1.jpg\" /> Samantha\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Harris</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"block\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/2.jpg\" /> Scott\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Thompson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t<span><i class=\"icon  fa fa-home\"></i> Family</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">A</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"busy\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/3.jpg\" /> Adam\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>White</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">B</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"busy\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/4.jpg\" /> Ben\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Robinson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/5.jpg\" /> Bruce\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Lee</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">E</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/6.jpg\" /> Eddie\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Williams</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">J</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/7.jpg\" /> Jack\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Johnson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/8.jpg\" /> John\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Jackman</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">M</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/9.jpg\" /> Martina\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Thompson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"busy\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/10.jpg\" /> Matthew\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Watson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">O</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/1.jpg\" /> Olivia\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Taylor</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/2.jpg\" /> Owen\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Wilson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li data-counter-color=\"theme-inverse\">\r\n\t\t\t\t\t\t\t\t<span><i class=\"icon  fa fa-briefcase\"></i> Work colleagues</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">D</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/3.jpg\" /> David\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Harris</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/4.jpg\" /> Dennis\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>King</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">E</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/5.jpg\" /> Eliza\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Walker</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">L</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"busy\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/6.jpg\" /> Larry\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Turner</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/7.jpg\" /> Lisa<br />\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Wilson</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">M</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/8.jpg\" /> Michael\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Jordan</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">R</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/9.jpg\" /> Rachelle\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>Cooper</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/10.jpg\" /> Rick\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small>James</small>\r\n\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"Label label-lg\">Total week Earnings</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t<span><i class=\"icon  fa fa-bar-chart-o\"></i> See This week</span>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">themeforest</li>\r\n\t\t\t\t\t\t\t\t\t\t<li><span><i class=\"label label-warning pull-right\">HTML</i> Earnings $395 </span></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><span> Earnings $485 </span></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><span><i class=\"label label-info pull-right\">Wordpress</i> Earnings $1,589 </span></li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">codecanyon </li>\r\n\t\t\t\t\t\t\t\t\t\t<li><span><i class=\"label label-danger pull-right\">Item 6537086</i> Earnings $897</span></li>\r\n\t\t\t\t\t\t\t\t\t\t<li><span>Sunday Earnings $395</span></li>\r\n\t\t\t\t\t\t\t\t\t\t<li class=\"Label\">Other</li>\r\n\t\t\t\t\t\t\t\t\t\t<li><span><i class=\"label label-success  pull-right\">up 35%</i> Total Earnings $5,025</span></li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t<div class=\"widget-mini-chart align-xs-right\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"pull-left\">\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"sparkline mini-chart\" data-type=\"bar\" data-color=\"warning\" data-bar-width=\"10\" data-height=\"45\">2,3,7,5,4,6,6,3</div>\r\n\t\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\t\t<p>This week Earnings</p>\r\n\t\t\t\t\t\t\t\t\t\t\t<h4>$11,987</h4>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<!-- //widget-mini-chart -->\t\t\t\r\n\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"Label label-lg\">Processing </li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t<span>\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<p>Server Processing</p>\r\n\t\t\t\t\t\t\t\t\t<div class=\"progress progress-dark progress-stripes progress-xs\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress-bar bg-danger\" aria-valuetransitiongoal=\"37\"></div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<label class=\"progress-label\">Today , CPU 37%</label>\r\n\t\t\t\t\t\t\t\t\t<!-- //progress-->\r\n\t\t\t\t\t\t\t\t\t<div class=\"progress progress-dark progress-xs\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"progress-bar bg-warning\" aria-valuetransitiongoal=\"23\"></div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<label class=\"progress-label lasted\">Today , Server load  22.85%</label>\r\n\t\t\t\t\t\t\t\t\t<!-- //progress-->\r\n\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"Label label-lg\">Quick Friends Chat </li>\r\n\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/1.jpg\" /> Olivia\r\n\t\t\t\t\t\t\t\t\t\t<small>Taylor</small>\r\n\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/2.jpg\" /> Owen\r\n\t\t\t\t\t\t\t\t\t\t<small>Wilson</small>\r\n\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t<a href=\"#\">\r\n\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/8.jpg\" /> Meagan\r\n\t\t\t\t\t\t\t\t\t\t<small>Miller</small>\r\n\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t<a href=\"#\" class=\"busy\">\r\n\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/9.jpg\" /> Melissa\r\n\t\t\t\t\t\t\t\t\t\t<small>Johnson</small>\r\n\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"img\">\r\n\t\t\t\t\t\t\t\t<a href=\"#\" class=\"online\">\r\n\t\t\t\t\t\t\t\t\t\t<img alt=\"\" src=\"assets/photos_preview/50/people/5.jpg\" /> Samantha\r\n\t\t\t\t\t\t\t\t\t\t<small>Harris</small>\r\n\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t<li class=\"Label label-lg\">visitors Real Time</li>\r\n\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t<span>\r\n\t\t\t\t\t\t\t\t\t<div class=\"widget-chart\">\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"realtimeChart\" class=\"demo-placeholder\" style=\"height:150px\"></div>\r\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"realtimeChartCount\" class=\"align-lg-center\"><span>0</span> visitors on site </div>\r\n\t\t\t\t\t\t\t\t\t</div><!-- // widget-chart -->\r\n\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</li>\r\n\t\t\t\t</ul>\r\n\t\t</nav>\r\n\t\t<!-- //nav right menu-->\r\n\t\t\r\n\t\t\r\n</div>\r\n<!-- //wrapper-->\r\n\r\n"

/***/ }),

/***/ 802:
/***/ (function(module, exports) {

module.exports = "<p>\n  institution works!\n</p>\n"

/***/ })

},[1086]);
//# sourceMappingURL=main.bundle.map