package com.arq.millermosquera.samplesmc;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
// tiDerecho.addTextChangedListener(new TextWatcherCurrencyFormat(tiDerecho, tilDerecho));
public class TextWatcherCurrencyFormat implements TextWatcher {

    private EditText editText;
    private TextInputLayout tilEditText;

    private String current = "";

    public  TextWatcherCurrencyFormat(EditText editText){
        this.editText = editText;
    }

    public  TextWatcherCurrencyFormat(EditText editText,TextInputLayout tilEditText){
        this.editText = editText;
        this.tilEditText  = tilEditText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(tilEditText!=null){
            tilEditText.setError(null);
            tilEditText.setErrorEnabled(false);
        }
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        editText.setError(null);
        if(!charSequence.toString().equals(current) && !charSequence.toString().isEmpty()){
            if ("$".equals(charSequence.toString())) {
                current = "";
            } else {
                current = TextUtils.getMoneyFormat(charSequence.toString().replaceAll("[^0-9]", ""));
            }
            editText.setText(current);
            editText.setSelection(current.length());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
