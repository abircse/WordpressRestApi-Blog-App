import com.google.gson.annotations.SerializedName

data class BaseDataModel (
	@SerializedName("id") val id : Int,
	@SerializedName("date") val date : String,
	@SerializedName("date_gmt") val date_gmt : String,
	@SerializedName("guid") val guid : Guid,
	@SerializedName("modified") val modified : String,
	@SerializedName("modified_gmt") val modified_gmt : String,
	@SerializedName("slug") val slug : String,
	@SerializedName("status") val status : String,
	@SerializedName("type") val type : String,
	@SerializedName("link") val link : String,
	@SerializedName("title") val title : Title,
	@SerializedName("content") val content : Content,
	@SerializedName("excerpt") val excerpt : Excerpt,
	@SerializedName("author") val author : Int,
	@SerializedName("featured_media") val featured_media : Int,
	@SerializedName("categories") val categories : List<Int>,
)