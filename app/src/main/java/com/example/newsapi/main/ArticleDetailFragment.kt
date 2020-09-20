package com.example.newsapi.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.newsapi.R
import com.example.newsapi.models.Article
import kotlinx.android.synthetic.main.fragment_article_detail.*

private const val ARG_PARAM1 = "param1"

class ArticleDetailFragment : Fragment() {

    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            article = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewAuthor.text = article!!.author
        textViewDetail.text = article!!.description
        textViewTitle.text =article!!.title
        Glide.with(activity!!).load(article!!.urlToImage).centerCrop().into(imageViewArticle)
    }

    companion object {

        @JvmStatic
        fun newInstance(article: Article) =
            ArticleDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, article)
                }
            }
    }
}