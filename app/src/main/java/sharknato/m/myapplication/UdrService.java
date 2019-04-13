package sharknato.m.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UdrService {
    //Select
    @GET("api/v1/Udr")
    Call<List<Udr>> getUdrs();

    //Create
    @POST("add/")
    Call<Udr> addUdr (@Body Udr udr);
    //Update
    @PUT("update/{id}")
    Call<Udr> upadaUdrCall(@Path("id") int id,@Body Udr udr);
    //Delete
    @DELETE("delete/{id}")
    Call<Udr> deleUdrCall(@Path("id")int id,@Body Udr udr);


}
