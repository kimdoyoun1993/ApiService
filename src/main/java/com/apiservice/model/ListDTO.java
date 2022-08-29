package com.apiservice.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ListDTO{

   private int page;

   private int size;

   public ListDTO(){
           this.page = 1; //page 는 기본이 1 page
           this.size = 10; // size 는 기본 10개
        }

   public void setPage(int page){

           this.page = page <= 0? 1:page;
   }

   public void setSize(int size){

           this.size = size < 10? 10:size;
   }

   public int getSkip(){

           return (this.page - 1) * size;
   }

}
