package com.example.personalassistant;



import com.example.personalassistant.model.BalanceResponse;
import com.example.personalassistant.model.BalanceBody;
import com.example.personalassistant.model.ExpenseResponse;
import com.example.personalassistant.model.ExpenseBody;
import com.example.personalassistant.model.IncomResponse;
import com.example.personalassistant.model.IncomBody;
import com.example.personalassistant.model.LoginBody;
import com.example.personalassistant.model.LoginResponse;
import com.example.personalassistant.model.Summary;
import com.example.personalassistant.model.SummaryBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface ServicesAPI {


        @POST("Usr/Login")
      Call<LoginResponse> userLogin(@Body LoginBody loginBody);
     //Call<LoginResponse> userLogin(EditText email, EditText password);
       @POST("Rpt/Blnc")
        Call<BalanceResponse> userBalance(@Body BalanceBody balance);

           @POST("Inc")
        Call<IncomResponse> userIncom(@Body IncomBody incom);
    @POST("Exp")
    Call<ExpenseResponse> userExpense(@Body ExpenseBody expense);

    @POST("Rpt/SmryRpt")
    Call<Summary> userSummary(@Body SummaryBody summary);
    // @POST("Rpt/Blnc")
   // Call<User> balance(@Body User user);
}
