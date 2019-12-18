import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm, FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-add-asset',
  templateUrl: './add-asset.component.html',
  styleUrls: ['./add-asset.component.css']
})
export class AddAssetComponent implements OnInit, OnDestroy {
  error: any;
  addAppartmentForm: FormGroup;
  constructor(private auth: AuthServiceService) { }

  addAppartmentData() {
    this.error = null;
    console.log(this.addAppartmentForm);
    this.auth.addAsset(this.addAppartmentForm.value).subscribe(res => {
      console.log(res);
      this.error = res.message;
      this.addAppartmentForm.reset();
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
    this.addAppartmentForm = new FormGroup({
      appartmentArea: new FormControl('', [Validators.required]),
      appartmentName: new FormControl('', [Validators.required]),
      flats: new FormArray([
        this.flatField()
      ])
    });
  }
  flatField() {
    return new FormGroup({
      flatType: new FormControl(),
      cost: new FormControl()
    });
  }
  addFlat() {
    (this.addAppartmentForm.get('flats') as FormArray).push(this.flatField());
  }
  removeFlat(i: number) {
    (this.addAppartmentForm.get('flats') as FormArray).removeAt(i);
  }
  ngOnDestroy() {
    this.error = null;
  }
}
