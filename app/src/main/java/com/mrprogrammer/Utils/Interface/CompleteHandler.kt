package com.mrprogrammer.Utils.Interface

interface CompleteHandler {
    fun onSuccess(Message: Any)
    fun onFailure(e: String)
}