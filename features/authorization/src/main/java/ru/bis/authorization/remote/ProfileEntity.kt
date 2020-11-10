package ru.bis.authorization.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProfileEntity (
    @SerializedName("firstName")
    @Expose
    val firstName:String,

    @SerializedName("secondName")
    @Expose
    val secondName:String,

    @SerializedName("lastName")
    @Expose
    val lastName:String,

    @SerializedName("name")
    @Expose
    val name:String,

    @SerializedName("full_name")
    @Expose
    val fullName:String,

    @SerializedName("birthday")
    @Expose
    val birthday:String,

    @SerializedName("factAddress")
    @Expose
    val factAddress:String,

    @SerializedName("registrationAddress")
    @Expose
    val registrationAddress:String,

    @SerializedName("passport")
    @Expose
    val passport:String,

    @SerializedName("checkingAccount")
    @Expose
    val checkingAccount:String,

    @SerializedName("photo")
    @Expose
    val photo:String,

    @SerializedName("inn")
    @Expose
    val inn:String,

    @SerializedName("kpp")
    @Expose
    val kpp:String,

    @SerializedName("ogrn")
    @Expose
    val ogrn:String,

    @SerializedName("id")
    @Expose
    val id:String,

    @SerializedName("company")
    @Expose
    val company:String,

    @SerializedName("description")
    @Expose
    val description:String,

    @SerializedName("isLegal")
    @Expose
    val isLegal:String,

    @SerializedName("createDate")
    @Expose
    val createDate:String,

    @SerializedName("modifyDate")
    @Expose
    val modifyDate:String,

    @SerializedName("role")
    @Expose
    val role:String
)