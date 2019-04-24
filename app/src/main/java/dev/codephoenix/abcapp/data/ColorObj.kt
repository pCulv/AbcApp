package dev.codephoenix.abcapp.data

import android.os.Parcel
import android.os.Parcelable

data class ColorObj(
    val colorName: String,
    val colorHex: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(colorName)
        parcel.writeInt(colorHex)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ColorObj> {
        override fun createFromParcel(parcel: Parcel): ColorObj {
            return ColorObj(parcel)
        }

        override fun newArray(size: Int): Array<ColorObj?> {
            return arrayOfNulls(size)
        }
    }
}
