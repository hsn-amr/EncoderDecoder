package com.example.encoderdecoder

import kotlin.math.absoluteValue

class Encryption(var originalText: String) {

    var cipherText = ""
    var alphabet = "abcdefghijklmnopqrstuvwxyz"
    var alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var specialCharacters = "\" !#\\$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789\""
    val k = 13

    fun encode(): String {
        for(l in originalText){
            if(l !in specialCharacters){
                if(l in alphabet){
                    val indexOfChar = alphabet.indexOf(l)
                    val y = (indexOfChar + k)%26
                    cipherText += if(y < 0){
                        alphabet[indexOfChar+k]
                    }else{
                        alphabet[y]
                    }
                }else{
                    val indexOfChar = alphabetUpperCase.indexOf(l)
                    val y = (indexOfChar + k)%26
                    cipherText += if(y < 0){
                        alphabetUpperCase[indexOfChar+k]
                    }else{
                        alphabetUpperCase[y]
                    }
                }
            }else{
                cipherText += l
            }
        }
        return cipherText
    }

    fun decode(): String {
        for(l in originalText){
            if(l !in specialCharacters){
                if(l in alphabet){
                    val indexOfChar = alphabet.indexOf(l)
                    val y = (indexOfChar - k)%26
                    cipherText += if(y > 0){
                        alphabet[y]
                    }else{
                        alphabet[(indexOfChar+k).absoluteValue]
                    }
                }else{
                    val indexOfChar = alphabetUpperCase.indexOf(l)
                    val y = (indexOfChar - k)%26
                    cipherText += if(y > 0){
                        alphabetUpperCase[y]
                    }else{
                        alphabetUpperCase[(indexOfChar+k).absoluteValue]
                    }
                }
            }else{
                cipherText += l
            }
        }
        return cipherText
    }
}