package com.apiservice.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ListDTO{

   private int page;

   private int size;

   private String type; // 겁색 타입

   private String keyword; // 키워드


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

   public String[] getTypes(){
       if (type == null){
           return new String[]{};
       }
       return type.split("");
   } // 조건이 없을때는 빈 배열을 리턴해준다

   public String getKeyword(){

       return keyword == null? null:keyword.trim();
   } // 키워드는 없을수 없다

    public void setType(String type) {
        this.type = type;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


}
