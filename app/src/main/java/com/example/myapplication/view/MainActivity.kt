package com.example.myapplication.view;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.model.RepoResponse
import com.example.myapplication.presenter.PresenterContract
import com.example.myapplication.util.ApplicationData.daggerPresenterComponent
import com.example.myapplication.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PresenterContract.GitRepoView {
    override fun callFailed() {
//        TODO: handle error
    }

    @Inject
    lateinit var gitRepositoryPresenter: PresenterContract.GitRepoPresenter


    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daggerPresenterComponent?.inject(this)
//        gitRepositoryPresenter.setRepoView(this)

        compositeDisposable.add(
                gitRepositoryPresenter.getRepositories().observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ myList ->
                            printMyList(myList)
                        }, { throwable ->
                            //                    TODO: Use ErrorLogger TM
                        })


        )

    }

    private fun printMyList(list: List<RepoResponse>) {
        displayUserAvatar()

        val stringBuilder = StringBuilder()
        list.forEach { item ->
            stringBuilder.append("${item.name}\n")
        }

        my_textview.text = stringBuilder
    }

    private fun displayUserAvatar() {
        val fragment = MyProfileFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.my_framelayout, fragment)
                .addToBackStack(fragment.tag)
                .commit()

    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }
}
