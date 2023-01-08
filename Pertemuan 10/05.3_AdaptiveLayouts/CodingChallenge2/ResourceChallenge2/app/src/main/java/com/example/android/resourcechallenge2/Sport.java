/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.resourcechallenge2;

import android.os.Parcel;
import android.os.Parcelable;

class Sport implements Parcelable {

    private String title;
    private String info;
    private String details;
    private final int imageResource;

    Sport(String title, String info, int imageResource, String details) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.details = details;
    }

    private Sport(Parcel in) {
        title = in.readString();
        info = in.readString();
        details = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };

    String getTitle() {
        return title;
    }
    String getInfo() {
        return info;
    }
    public int getImageResource() {
        return imageResource;
    }
    String getDetails() {
        return details;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(info);
        dest.writeString(details);
        dest.writeInt(imageResource);
    }
}