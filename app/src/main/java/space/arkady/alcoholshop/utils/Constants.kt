package space.arkady.alcoholshop.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.webkit.MimeTypeMap

object Constants {
    const val USERS = "users"
    const val MYALCOHOLSHOP_PREFS = "MyAlcoholShopPrefs"
    const val LOGGED_IN_USERNAME = "logged_in_username"
    const val EXTRA_USER_DETAILS = "extra_user_details"
    const val READ_STORAGE_PERMISSION_CODE = 2
    const val PICK_IMAGE_REQUEST_CODE = 1

    const val MALE = "male"
    const val FEMALE = "female"

    const val MOBILE = "mobile"
    const val GENDER = "gender"
    const val IMAGE= "image"
    const val COMPLETED_PROFILE = "profileCompleted"
    const val DRINKS_COLLECTION = "drinks"

    const val USER_PROFILE_IMAGE = "User_Profile_Image"

    const val BEER = "beer"
    const val STYLE = "style"
    const val BRAND = "brand"
    const val FERMENTATION = "fermentation"
    const val PRICE = "price"
    const val PRODUCER = "producer"
    const val REGION = "region"
    const val IMAGE_URI = "imageUri"
    const val VOLUME = "volume"
    const val STRENGTH = "strength"

    fun showImageChooser(activity: Activity) {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        activity.startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST_CODE)
    }

    fun getFileExtension(activity: Activity, uri: Uri?): String? {
        //MimeTypeMap: Two-way map that maps MIME types to file extensions and vice-versa.
        //getSingleton(): Get the singleton instance instead of map
        //getExtensionFromMimeType: Return the registered extension for the given MIME type
        //contentResolver.getType: Return the MIME type of the given content URL.
        //c:/user/arkady/download/cat.png

        return MimeTypeMap.getSingleton()
            .getExtensionFromMimeType(activity.contentResolver.getType(uri!!))
    }
}