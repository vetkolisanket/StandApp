package com.vetkoli.sanket.standapp.base.ui.activities

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.vetkoli.sanket.standapp.base.contract.IBaseContract

/**
 * Created by Sanket on 30/11/17.
 */

abstract class BaseActivity : AppCompatActivity() , IBaseContract.BaseView {

//    val parentContainer: LinearLayout by bindView<LinearLayout>(R.id.parent_container)

    override val context: Context
        get() = this

    override fun toast(message: String, duration: Int) {
        Toast.makeText(this, message, duration).show()
    }

    abstract override fun snack(message: String, duration: Int, buttonString: String, listener: View.OnClickListener?)

    protected fun showSnack(message: String, duration: Int, buttonString: String, listener: View.OnClickListener?, view: View) {
        val snackbar = Snackbar.make(view, message, duration)
        snackbar.setAction(buttonString, listener)
        snackbar.show()
    }

    protected fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

}
