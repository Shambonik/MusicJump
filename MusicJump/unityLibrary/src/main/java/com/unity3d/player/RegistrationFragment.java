package com.unity3d.player;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.unity3d.player.model.PostRegistrationUser;
import com.unity3d.player.retrofit.ApiService;
import com.unity3d.player.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.app.AlertDialog;
import java.util.ArrayList;

public class RegistrationFragment extends Fragment implements View.OnClickListener{
    private ApiService apiService;
    private View v;


    /**
     * Метод создания фрагмента, в котором можно получить ранее сохраненное состояние фрагмента
     * @param savedInstanceState - сохраненные параметры фрагмента
     * */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.registration_form, null);
        setClickers(v);

        EditText login = (EditText) v.findViewById(R.id.log);
        EditText psw = (EditText) v.findViewById(R.id.psw);
        EditText psw2 = (EditText) v.findViewById(R.id.pswConfirm);
        Button button = (Button) v.findViewById(R.id.registration_submit);

//        TextView response = (TextView) v.findViewById(R.id.notification);

        apiService = RetrofitClient.getInstance().getApi();

        button.setOnClickListener(view -> {
            String username = login.getText().toString().trim();
            String password = psw.getText().toString().trim();
            String confirm_password = psw2.getText().toString().trim();

            sendUser(username, password, confirm_password);
        });

        return v;
    }

    public void sendUser(String username, String password, String confirm_password){
        PostRegistrationUser user = new PostRegistrationUser(username, password, confirm_password);
        Call<String> call = apiService.savePost(user);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    AlertDialog.Builder adb = new AlertDialog.Builder(v.getContext());
                    adb.setTitle(response.body());
                    adb.setPositiveButton("Перейти на страницу авторизации", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ((MainContent) requireActivity()).openFragment(4);
                            dialogInterface.cancel();
                        }
                    });
                    adb.setNegativeButton("Остаться на странице", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    adb.create();
                    adb.show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    };

    /**
     * Метод - обработчик нажатия на кнопку
     * @param v - элемент, над которым произошло действие
     * */
    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.to_menu) {
            ((MainContent) requireActivity()).openFragment(0);
        }
    }

    /**
     * Метод, устанавливающий обработчики нажатия для кнопок меню
     * @param v - представление фрагмента меню
     * */
    private void setClickers(View v){
        ArrayList<View> touchables = v.getTouchables();
        for (View button : touchables){
            if(button instanceof Button){
                button.setOnClickListener(this);
            }
        }
    }
}
