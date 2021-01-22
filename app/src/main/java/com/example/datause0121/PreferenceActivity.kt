package com.example.datause0121

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preference.*

class PreferenceActivity : AppCompatActivity() {
    //지연 생성을 이용해 환경 설정 객체 생성
    val preference by lazy {getSharedPreferences("PreferenceActivity", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        //시작시 환경설정의 내용 읽어오기
        nameField.setText(
            preference.getString("nameField",""))
        pushCheckBox.isChecked = preference.getBoolean(
            "pushCheckboxField",false)

        //환경설정에 저장하기
        saveBtn.setOnClickListener{
            preference.edit().putString("nameField", nameField.text.toString()).apply()
            preference.edit().putBoolean("pushCheckBoxField", pushCheckBox.isChecked).apply()
        }

        //환경설정에서 읽어오기
        loadBtn.setOnClickListener{
            nameField.setText(
                preference.getString("nameField",""))
            pushCheckBox.isChecked = preference.getBoolean(
                "pushCheckboxField",false)
        }
    }
}