package ru.petriwna.mytestideaintech.model

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("companyDetails")
	val companyDetails: CompanyDetails? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("admin")
	val admin: Boolean? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("confirmed")
	val confirmed: Boolean? = null,

	@field:SerializedName("email")
	val email: String? = null
)