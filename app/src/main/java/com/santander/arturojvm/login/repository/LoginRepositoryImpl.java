package com.santander.arturojvm.login.repository;

import com.santander.arturojvm.login.repository.endpoints.LoginEndPoints;
import com.santander.arturojvm.login.repository.entity.DataLoginPasswordData;
import com.santander.arturojvm.login.repository.entity.RequestLoginPasswordData;
import com.santander.arturojvm.login.repository.entity.ResponseLoginPasswordData;
import com.santander.arturojvm.login.repository.service.ServiceLoginGenerator;
import rx.Observable;

/**
 * Created by arturo on 15/02/17.
 */

public class LoginRepositoryImpl implements LoginRepository {

    private static LoginRepository loginRepository;
    private static LoginEndPoints loginEndPoints;

    public static LoginRepository getInstance() {
        if (loginRepository == null) {

            loginRepository = new LoginRepositoryImpl();

            ServiceLoginGenerator serviceLoginGenerator = new ServiceLoginGenerator();
            loginEndPoints = serviceLoginGenerator.createService(LoginEndPoints.class);

        }
        return loginRepository;
    }

    @Override
    public Observable<ResponseLoginPasswordData> loginPassword(String user, String password) {

        RequestLoginPasswordData request = new RequestLoginPasswordData();
        DataLoginPasswordData dataLogin = new DataLoginPasswordData();

        dataLogin.setUser(user);
        dataLogin.setPassword(password);

        request.setDataLogin(dataLogin);

        return loginEndPoints
                .loginPassword(request);
    }

}
