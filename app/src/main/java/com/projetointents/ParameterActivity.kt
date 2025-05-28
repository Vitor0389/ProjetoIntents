package com.projetointents

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.projetointents.Extras.PARAMETER_EXTRA
import com.projetointents.databinding.ActivityParameterBinding

class ParameterActivity : AppCompatActivity(){

    // APB criado para inflar o layout de activity
    private val apb: ActivityParameterBinding by lazy {
        ActivityParameterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        setSupportActionBar(apb.toolbarIn.toolbar)
        supportActionBar?.subtitle = localClassName

        intent.getStringExtra(PARAMETER_EXTRA).let {
            apb.parameterEt.setText(it)
        }

        apb.returnAndCloseBt.setOnClickListener {
            // Devolvendo o valor alterado para a MainActivity
            Intent().apply {
                putExtra(PARAMETER_EXTRA, apb.parameterEt.text.toString())
                setResult(RESULT_OK, this)
            }
            // Fechando a tela ParameterActiviy
            finish()
        }
    }
}