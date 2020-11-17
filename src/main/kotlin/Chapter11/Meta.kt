package Chapter11

import com.google.gson.annotations.SerializedName

data class Meta(

	@field:SerializedName("code")
	val code: Int? = null
)
