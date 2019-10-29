package com.example.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.presenter.PresenterContract
import com.example.myapplication.util.ApplicationData.daggerPresenterComponent
import com.example.myapplication.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.my_profile_fragment.*
import javax.inject.Inject

class MyProfileFragment : Fragment(), PresenterContract.GitUserView {

//    @Inject
//    lateinit var gitUserPresenter: PresenterContract.GitUserPresenter

    override fun callFailed() {
        //TODO: ErrorLogger TM
    }

    lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =
                inflater.inflate(R.layout.my_profile_fragment, container, false)
        return view
    }

    val compositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        daggerPresenterComponent?.inject(this)
//        gitUserPresenter.setUserView(this)

        compositeDisposable.add(//This is with MVP
//                gitUserPresenter.getUser().observeOn(AndroidSchedulers.mainThread())
//                        .subscribeOn(Schedulers.io())
//                        .subscribe({ myUser ->
//                            Glide.with(this)
//                                    .load(myUser.avatarUrl)
//                                    .into(profile_imageview)
//
//                        }, { throwable -> })

                //This is with MVVM
                viewModel.getUser().observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ myUser ->
                            Glide.with(this)
                                    .load(myUser.avatarUrl)
                                    .into(profile_imageview)

                        }, { throwable -> })
        )
    }

}