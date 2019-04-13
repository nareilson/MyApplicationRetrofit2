package sharknato.m.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.support.v7.widget.DividerItemDecoration;
import  android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String baseUrl = "https://5cb13e668bdfe80014e97e7b.mockapi.io/";
    List<Udr> varUdrsList = new ArrayList<>();
    UdrAdapter udrAdapter;
    RecyclerView reView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reView = findViewById(R.id.recyclerView);
        StartController();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LinearLayoutManager inearlayoutmanager = new LinearLayoutManager(getApplicationContext());
        reView.setLayoutManager(inearlayoutmanager);
        udrAdapter = new UdrAdapter(varUdrsList);
        reView.setAdapter(udrAdapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(reView.getContext(),inearlayoutmanager.getOrientation());
        reView.addItemDecoration(itemDecoration);

        UdrService udrService = retrofit.create(UdrService.class);

        final Call<List<Udr>> listaUdr = udrService.getUdrs();
        listaUdr.enqueue(new Callback<List<Udr>>() {
            @Override
            public void onResponse(Call<List<Udr>> call, Response<List<Udr>> response) {
               if(response.isSuccessful()){
                   varUdrsList = response.body();
                   udrAdapter = new UdrAdapter(varUdrsList);
                   reView.setAdapter(udrAdapter);
                   udrAdapter.notifyDataSetChanged();

               }

            }

            @Override
            public void onFailure(Call<List<Udr>> call, Throwable t) {

            }
        });


    }

    public void StartController(){

    }
}
