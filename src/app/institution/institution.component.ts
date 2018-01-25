import { Component, OnInit } from '@angular/core';
import {Place} from '../institution/place';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Http, Headers,Response,RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';




// import {institution} from '../../'

import {User} from '../classes/user';
import {UserService} from '../shared_service/user.service';
import { Institution } from '../institution/institution';
declare var $:any;


@Component({
  selector: 'app-institution',
  templateUrl: './institution.component.html',
  styleUrls: ['./institution.component.css']
})
export class InstitutionComponent implements OnInit {

  // private user:User; 
  valeur_souscategory : any;
  photo : any;
  allCategory: any;
  allInsterests: any;
  allTypeOffre : any;
  AllSousCategory : any;
  statusCode: number;
  idCategory : number;
  requestProcessing = false;
  articleIdToUpdate = null;
  processValidation = false;


   // Create form Institution    null, adresseIns, latitudeIns,longitudeIns,nomIns,photoIns,telephoneIns,descriptionIns,solde,price,
   institutionForm = new FormGroup({
    adresseIns: new FormControl('', Validators.required),
    latitudeIns: new FormControl('', Validators.required),
    longitudeIns: new FormControl('', Validators.required),
    // longitude: new FormControl('', Validators.required),
    nomIns: new FormControl('', Validators.required),
    // photoIns: new FormControl('', Validators.required),
    telephoneIns: new FormControl('', Validators.required),
    descriptionIns: new FormControl('', Validators.required),
    solde: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    idTypeoffre: new FormControl('', Validators.required),
    idCategory: new FormControl('', Validators.required),
    idSousCategory: new FormControl('', Validators.required),
    // idUser: new FormControl('', Validators.required),
    interestIdInterest: new FormControl('', Validators.required)


});
  
  constructor(private userService : UserService, public http: Http) {this.valeur_souscategory=false }

  ngOnInit() {
    this.getAllCategory();
    // this.getAllCategoryBySouscategory(idCategory);
    this.getAllInterets();
    this.getAllTypesOffres();
 

  }





 


   // Fetch all Category
  getAllCategory() {

    this.userService.getAllCategory().subscribe(
        data => {
          this.allCategory = data.category;
          console.log(this.allCategory);
          },
        errorCode => {
          this.statusCode = errorCode
          }
      );
  } 


  getAllInterets(){

      this.userService.getAllInterets().subscribe(
        data => {
          this.allInsterests = data.interests;
          console.log(this.getAllInterets);
          },
        errorCode => {
          this.statusCode = errorCode
          }
      );

  }


  getAllTypesOffres(){

    this.userService.getAllTypesOffres().subscribe(
      data => {
        this.allTypeOffre = data.offres;
        console.log(this.getAllTypesOffres);
        },
      errorCode => {
        this.statusCode = errorCode
        }
    );

    
  }
  getAllCategoryBySouscategory(idCategory) {

    this.userService.getAllCategoryBySouscategory(idCategory).subscribe(
      data => {
        this.AllSousCategory = data.sous_category;
        
        if (this.AllSousCategory==null){
          this.valeur_souscategory=false;
        }else{
          this.valeur_souscategory=true;
        }
        console.log(this.AllSousCategory);
        },
      errorCode => {
        this.statusCode = errorCode
        }
    );
  } 



  onInstitutionFormSubmit() {
    this.processValidation = true; 
    
    

    /*if (this.evenementForm.invalid) {
        console.log("okkk no");
         return; //Validation failed, exit from method.
    } */ 
    //Form is valid, now perform create or update
      this.preProcessConfigurations();
      
      
      
      
      
      /*
      
      let adresseIns = this.institutionForm.get('adresse').value.trim();
      let latitudeIns = this.institutionForm.get('latitude').value.trim();
      let longitudeIns = this.institutionForm.get('longitude').value.trim();
      let nomIns = this.institutionForm.get('nom').value.trim();
      let photoIns = this.institutionForm.get('photo').value.trim();
      let telephoneIns = this.institutionForm.get('telephone').value.trim();
      let descriptionIns = this.institutionForm.get('description').value.trim();
      let solde = this.institutionForm.get('solde').value.trim(); 
      let price = this.institutionForm.get('price').value.trim(); 
      let idTypeOffre = this.institutionForm.get('idTypeOffre').value.trim();  
      let idCategory = this.institutionForm.get('idCategory').value.trim();  
      let idSousCategory = this.institutionForm.get('idSousCategory').value.trim();  
      let interestIdInterest = this.institutionForm.get('interest').value.trim(); 
      
      */ 

      var json = this.institutionForm.value;
 
      let adresseIns = json.adresseIns;
      let latitudeIns = +json.latitudeIns;
      let longitudeIns = +json.longitudeIns;
      let nomIns = json.nomIns;
      // let photoIns = json.photoIns;
      let telephoneIns = +json.telephoneIns;
      let descriptionIns = json.descriptionIns;
      let solde = json.solde;
      let price = json.price;
      let idTypeoffre = +json.idTypeoffre;
      let idCategory = +json.idCategory;
      let idSousCategory = +json.idSousCategory;
      
      /*if (idCategory){
        idSousCategory = null;
      }*/
      if (idSousCategory==0){
        idSousCategory = null;
      }

      let interestIdInterest = +json.interestIdInterest;
      console.log(" adresseIns ");
      console.log(adresseIns);

      

      
      /*

      idTypeoffre: new FormControl('', Validators.required),
    idCategory: new FormControl('', Validators.required),
    idSousCategory: new FormControl('', Validators.required),
    // idUser: new FormControl('', Validators.required),
    interestIdInterest: new FormControl('', Validators.required)

    */ 

 
      //Handle create article





      let institution = new Institution(null, adresseIns, latitudeIns,longitudeIns,nomIns,this.photo,telephoneIns,descriptionIns,solde,price,idCategory,idSousCategory,idTypeoffre,interestIdInterest);
      console.log(institution);
      console.log("TEST VALEUR DE SOUS CATEGORIE ");

      // idTypeoffre, idCategory, idSousCategory, idUser, interestIdInterest

      /*
      if(!this.institutionForm.valid) {
        console.log("okkk no "+this.institutionForm.valid);
        console.log(" BAKHOUL ");
        console.log(institution);
        return; //Validation failed, exit from method.
      }
      */
      
      this.userService.createInstitution(institution)
        .subscribe(successCode => {
                this.statusCode = successCode;
                console.log(successCode);
          },
            errorCode => this.statusCode = errorCode);
            
            
    
   }
 
   //Perform preliminary processing configurations
   preProcessConfigurations() {
      this.statusCode = null;
    this.requestProcessing = true;  
   }
   //Go back from update to create
   backToCreateArticle() {
      this.articleIdToUpdate = null;
      this.institutionForm.reset();  
    this.processValidation = false;
   }
 
    onChange(files) {
      console.log(files);
    }



    fileChange(event) {
      let fileList: FileList = event.target.files;
      if (fileList.length > 0) {
        let file: File = fileList[0];
        let formData: FormData = new FormData();
        formData.append('uploadFile', file, file.name);
        let headers = new Headers();
        //headers.append('Accept', 'application/json');
        let options = new RequestOptions({ headers: headers });
        this.http.post(this.userService.URL_PHOTO, formData, options)
          .map(res => res.json())  
          .catch(error => Observable.throw(JSON.parse(JSON.stringify(error))))
          .subscribe(
          data => {
            console.log(data);
            this.photo = data.message;

            },
          error => console.log(error)
          )
      }
    }


}
