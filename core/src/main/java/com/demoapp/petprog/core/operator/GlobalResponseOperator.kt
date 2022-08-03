/*
 * Designed and developed by 2021 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demoapp.petprog.core.operator

import ErrorResponseMapper
import android.content.Context
import android.widget.Toast
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.StatusCode
import com.skydoves.sandwich.map
import com.skydoves.sandwich.message
import com.skydoves.sandwich.operators.ApiResponseSuspendOperator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class GlobalResponseOperator<T> constructor(
  private val context: Context
) : ApiResponseSuspendOperator<T>() {

  // handle the case when the API request gets a success response.
  override suspend fun onSuccess(apiResponse: ApiResponse.Success<T>) = Unit

  // handles the case when the API request gets an error response.
  // e.g., internal server error.
  override suspend fun onError(apiResponse: ApiResponse.Failure.Error<T>) =
    withContext(Dispatchers.IO) {
      apiResponse.run {
        Timber.d(message())

        withContext(Dispatchers.Main) {
          // handling error based on status code.
          when (statusCode) {
            StatusCode.InternalServerError -> toast("InternalServerError")
            StatusCode.BadGateway -> toast("BadGateway")
            else -> toast("$statusCode(${statusCode.code}): ${message()}")
          }
        }

        /** maps the [ApiResponse.Failure.Error] to the [MovieErrorResponse] using the mapper. */
        map(ErrorResponseMapper) {
          Timber.d(message())
        }
      }
    }

  // handle the case when the API request gets a exception response.
  // e.g., network connection error.
  override suspend fun onException(apiResponse: ApiResponse.Failure.Exception<T>) =
    apiResponse.run {
      Timber.d(message())
    }

  private fun toast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
  }
}
