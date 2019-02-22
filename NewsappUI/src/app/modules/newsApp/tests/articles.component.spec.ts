import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ArticlesComponent } from '../component/articles/articles.component';


describe('ArticlesComponent', () => {
  let component: ArticlesComponent
  ;
  let fixture: ComponentFixture<ArticlesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticlesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

 
});
