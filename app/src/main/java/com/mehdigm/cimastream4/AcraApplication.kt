package com.mehdigm.cimastream4

/**
 * Deprecated alias for CimaStreamApp for backwards compatibility with plugins.
 * Use CimaStreamApp instead.
 */
@Deprecated(
    message = "AcraApplication is deprecated, use CimaStreamApp instead",
    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp"),
    level = DeprecationLevel.ERROR
)
class AcraApplication {
	companion object {

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.context"),
		    level = DeprecationLevel.ERROR
		)
		val context get() = CimaStreamApp.context

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.removeKeys(folder)"),
		    level = DeprecationLevel.ERROR
		)
		fun removeKeys(folder: String): Int? =
		    CimaStreamApp.removeKeys(folder)

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.setKey(path, value)"),
		    level = DeprecationLevel.ERROR
		)
		fun <T> setKey(path: String, value: T) =
			CimaStreamApp.setKey(path, value)

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.setKey(folder, path, value)"),
		    level = DeprecationLevel.ERROR
		)
		fun <T> setKey(folder: String, path: String, value: T) =
			CimaStreamApp.setKey(folder, path, value)

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.getKey(path, defVal)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(path: String, defVal: T?): T? =
			CimaStreamApp.getKey(path, defVal)

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.getKey(path)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(path: String): T? =
			CimaStreamApp.getKey(path)

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.getKey(folder, path)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(folder: String, path: String): T? =
		    CimaStreamApp.getKey(folder, path)

		@Deprecated(
		    message = "AcraApplication is deprecated, use CimaStreamApp instead",
		    replaceWith = ReplaceWith("com.mehdigm.cimastream4.CimaStreamApp.getKey(folder, path, defVal)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(folder: String, path: String, defVal: T?): T? =
			CimaStreamApp.getKey(folder, path, defVal)
	}
}
