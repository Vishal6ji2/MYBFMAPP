package com.example.bfmapp.Suitcases;

import android.os.Parcel;
import android.os.Parcelable;

public class SelectGroupUserSuitcase implements Parcelable {

   public int profileimg;
   public String username;

   protected SelectGroupUserSuitcase(Parcel in) {
      profileimg = in.readInt();
      username = in.readString();
   }

   @Override
   public void writeToParcel(Parcel dest, int flags) {
      dest.writeInt(profileimg);
      dest.writeString(username);
   }

   public SelectGroupUserSuitcase() {

   }

   @Override
   public int describeContents() {
      return 0;
   }

   public static final Creator<SelectGroupUserSuitcase> CREATOR = new Creator<SelectGroupUserSuitcase>() {
      @Override
      public SelectGroupUserSuitcase createFromParcel(Parcel in) {
         return new SelectGroupUserSuitcase(in);
      }

      @Override
      public SelectGroupUserSuitcase[] newArray(int size) {
         return new SelectGroupUserSuitcase[size];
      }
   };
}
