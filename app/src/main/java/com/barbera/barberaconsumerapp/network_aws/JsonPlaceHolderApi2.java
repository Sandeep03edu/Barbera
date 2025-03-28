package com.barbera.barberaconsumerapp.network_aws;

import com.barbera.barberaconsumerapp.Bookings.BarberList;
import com.barbera.barberaconsumerapp.Bookings.BookingList;
import com.barbera.barberaconsumerapp.Bookings.BookingModel;
import com.barbera.barberaconsumerapp.Bookings.ServiceIdList;
import com.barbera.barberaconsumerapp.Utils.CartItemModel;
import com.barbera.barberaconsumerapp.Utils.CartList;
import com.barbera.barberaconsumerapp.Utils.CartList2;
import com.barbera.barberaconsumerapp.Utils.CouponItem;
import com.barbera.barberaconsumerapp.Utils.InstItem;
import com.barbera.barberaconsumerapp.Utils.ServiceItem;
import com.barbera.barberaconsumerapp.Utils.ServiceList;
import com.barbera.barberaconsumerapp.Utils.SliderList;
import com.barbera.barberaconsumerapp.Utils.TypeList;

import org.checkerframework.checker.nullness.compatqual.PolyNullType;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi2 {
    @POST("loginphone")
    Call<Register> getToken(@Body Register register);

    @POST("loginotp")
    Call<Register> checkOtp(@Body Register register, @Header("Authorization") String token);

    @POST("address")
    Call<Void> updateAddress(@Body Register register,@Header("Authorization") String token);

    @POST("profileupd")
    Call<Register> updateProfile(@Body Register register, @Header("Authorization") String token);

    @GET("getuser")
    Call<Register> getProfile(@Header("Authorization") String token);

    @GET("gettrend")
    Call<ServiceList> getTrending();

    @GET("gettypes/{category}")
    Call<TypeList> getTypes(@Path ("category") String gender);

    @POST("getsubtypes/{category}")
    Call<TypeList> getSubTypes(@Path ("category") String gender,@Body ServiceItem service);

    @POST("getallserv/{category}")
    Call<ServiceList> getAllServices(@Path ("category") String gender,@Body ServiceItem service);

    @POST("addtocart")
    Call<SuccessReturn> addToCart(@Body Success model,@Header("Authorization") String token);

    @GET("getcart")
    Call<CartList> getCart(@Header("Authorization") String token);

    @POST("quantity")
    Call<Void> updateQuantity(@Body CartItemModel cartList, @Header("Authorization") String token);

    @POST("deletefromcart/{serviceid}")
    Call<SuccessReturn> deleteFromCart(@Path("serviceid") String id,@Header("Authorization") String token);

    @GET("getbarb/{date}/{slot}")
    Call<BarberList> getBarbers(@Path("date") String date, @Path("slot") String slot, @Header("Authorization") String token);

    @POST("book/{date}/{slot}")
    Call<Void> bookBarber(@Body ServiceIdList serviceIdList,@Path("date") String date, @Path("slot") String slot, @Header("Authorization") String token);

    @GET("getbookings")
    Call<BookingList> getBookings(@Header("Authorization") String token);

    @POST("deletecart")
    Call<Void> deleteCart(@Body ServiceIdList list, @Header("Authorization") String token);

    @GET("getref")
    Call<Data> getReferral(@Header("Authorization") String token);

    @POST("usecoupon")
    Call<CouponItem> applyCoupon(@Body CartItemModel cartItemModel, @Header("Authorization") String token);

    //@GET("getusercoupons")
    //Call<> getCoupon();
    // data: serviceId,name,discount,lower_price_limit,upper_price_limit,used_by,user_limit,"BARERAREF",refquantity

    @POST("bookinst")
    Call<InstItem> bookInst(@Body ServiceIdList serviceIdList, @Header("Authorization") String token);

    @POST("bookconfirm")
    Call<Void> confirmBooking(@Body ServiceIdList serviceIdList,@Header("Authorization") String token);

    @POST("bookrevert")
    Call<Void> revertBooking(@Body ServiceIdList serviceIdList,@Header("Authorization") String token);

    @POST("bookslot/{date}/{slot}")
    Call<InstItem> bookSlot(@Body ServiceIdList serviceIdList,@Path("date") String date, @Path("slot") String slot, @Header("Authorization") String token);

    @POST("startserv")
    Call<Void> startOtp(@Body InstItem barberId,@Header("Authorization") String token);

    @POST("endserv")
    Call<Void> endOtp(@Body InstItem barberId,@Header("Authorization") String token);

    @GET("getslider")
    Call<SliderList> getSlider();

    @GET("gettabs")
    Call<SliderList> getTabs();


    //serviceId,barberId,slot,date

}
