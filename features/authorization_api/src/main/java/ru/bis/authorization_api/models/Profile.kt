package ru.bis.authorization_api.models

data class Profile (
    val firstName: String,
    val secondName:String,
    val lastName:String,
    val name:String,
    val fullName:String,
    val birthday:String,
    val factAddress:String,
    val registrationAddress:String,
    val passport:String,
    val checkingAccount:String,
    val inn:String,
    val kpp:String,
    val ogrn:String,
    val id:String,
    val company:String,
    val description:String,
    val isLegal:String,
    val createDate:String,
    val modifyDate:String,
    val role:String,
    var photo: String?
)