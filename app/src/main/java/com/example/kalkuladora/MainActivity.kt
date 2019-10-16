package com.example.kalkuladora

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import com.example.kalkuladora.acumulada as acumulada1

public var acumulada = ""
public var resultado=0.0
public var textR=""
public var operacion='c'
public var igual='j'
public var memoria=0.0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        acumulada1=""
        resultado=0.0
        operacion='c'
        igual='j'
        if(resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
            webVista.webChromeClient = object : WebChromeClient(){}
            webVista.webViewClient = object: WebViewClient(){}
            val setting:WebSettings= webVista.settings
            setting.javaScriptEnabled=true
            webVista.loadUrl("https://www.google.com")

        }

    }
    fun operacion(){
        if(tvAcumulado.text.equals("")){
                operacion.equals('c')
        }else{
        when(operacion) {
            '+' -> {
                resultado = resultado + (acumulada1).toDouble()
            }
            '-' -> {
                resultado = resultado - (acumulada1).toDouble()
            }
            '*' -> {
                resultado = resultado * (acumulada1).toDouble()
            }
            '/' -> {
                resultado = resultado / (acumulada1).toDouble()
            }
        } }
    }
    fun botones(view:View){
        when(view.id){
            R.id.b1->{
                acumulada1=acumulada1+"1"
                tvAcumulado.text = acumulada1
            }
            R.id.b2->{
                acumulada1=acumulada1+"2"
                tvAcumulado.text = acumulada1
            }
            R.id.b3->{
                acumulada1=acumulada1+"3"
                tvAcumulado.text = acumulada1
            }
            R.id.b4->{
                acumulada1=acumulada1+"4"
                tvAcumulado.text = acumulada1
            }
            R.id.b5->{
                acumulada1=acumulada1+"5"
                tvAcumulado.text = acumulada1
            }
            R.id.b6->{
                acumulada1=acumulada1+"6"
                tvAcumulado.text = acumulada1
            }
            R.id.b7->{
                acumulada1=acumulada1+"7"
                tvAcumulado.text = acumulada1
            }
            R.id.b8->{
                acumulada1=acumulada1+"8"
                tvAcumulado.text = acumulada1
            }
            R.id.b9->{
                acumulada1=acumulada1+"9"
                tvAcumulado.text = acumulada1
            }
            R.id.b0->{
                acumulada1=acumulada1+"0"
                tvAcumulado.text = acumulada1
            }

            R.id.bMultiplicar->{
                if(acumulada1.equals("")){
                    operacion='*'
                }else{
                    if(operacion.equals('c')){
                        if(igual.equals('=')){
                            acumulada1=""
                            tvAcumulado.text=acumulada1
                            tvResultado.text=resultado.toString()
                            igual=('j')
                        }else{
                            resultado=acumulada1.toDouble()
                            tvResultado.text= resultado.toString()
                        }
                    }
                    operacion()
                    operacion = '*'
                    acumulada1 = ""
                    tvResultado.text = resultado.toString()
                    tvAcumulado.text = acumulada1
                }
            }

            R.id.bDividir->{
                if(acumulada1.equals("")){
                    operacion='/'
                }else{

                    if(operacion.equals('c')){
                        resultado=acumulada1.toDouble()
                        tvResultado.text= resultado.toString()
                    }else
                        if(operacion.equals('c')){
                            if(igual.equals('=')){
                                acumulada1=""
                                tvAcumulado.text=acumulada1
                                tvResultado.text=resultado.toString()
                                igual=('j')
                            }else{
                                resultado=acumulada1.toDouble()
                                tvResultado.text= resultado.toString()
                            }
                        }
                        operacion()
                        operacion='/'
                        acumulada1=""
                        tvResultado.text = resultado.toString()
                        tvAcumulado.text = acumulada1
                    }
                }

            R.id.bSuma->{
                if(acumulada1.equals("")){
                    operacion='+'
                }else{
                    if(operacion.equals('c')){
                        if(igual.equals('=')){
                            acumulada1=""
                            tvAcumulado.text=acumulada1
                            tvResultado.text=resultado.toString()
                            igual=('j')
                        }else{
                            resultado=acumulada1.toDouble()
                            tvResultado.text= resultado.toString()
                        }
                    }
                    operacion()
                    operacion='+'
                    acumulada1=""
                    tvResultado.text = resultado.toString()
                    tvAcumulado.text = acumulada1
                }
            }
            R.id.bRestar->{
                if(acumulada1.equals("")){
                    operacion='-'
                }else{
                    if(operacion.equals('c')){
                        if(igual.equals('=')){
                            acumulada1=""
                            tvAcumulado.text=acumulada1
                            tvResultado.text=resultado.toString()
                            igual=('j')
                        }else{
                            resultado=acumulada1.toDouble()
                            tvResultado.text= resultado.toString()
                        }
                    }
                    operacion()
                    operacion='-'
                    acumulada1=""
                    tvResultado.text= resultado.toString()
                    tvAcumulado.text= acumulada1
                }
            }
            R.id.bM->{
                memoria=memoria+resultado
            }
            R.id.bMC->{
                memoria= 0.0
            }
            R.id.bMR->{
                tvResultado.text=memoria.toString()
            }
            R.id.bIgual->{
                if(tvAcumulado.text.equals("")){

                }else {
                    if (operacion.equals('c')) {
                        //acumulada1 = ""
                        //resultado = 0.0
                        acumulada1=tvAcumulado.text.toString()
                        tvResultado.text = acumulada1
                        tvAcumulado.text = ""
                    } else {
                        igual = '='
                        operacion()
                        acumulada1 = ""
                        tvAcumulado.text = acumulada1
                        tvResultado.text = resultado.toString()

                    }
                }
            }

            R.id.bCE->{
                acumulada1=""
                resultado=0.0
                tvAcumulado.text=acumulada1
                tvResultado.text=""
                operacion='c'
                igual='j'
            }

        }

    }
}
