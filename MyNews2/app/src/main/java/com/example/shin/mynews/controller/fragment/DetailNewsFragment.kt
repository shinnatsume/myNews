package com.example.shin.mynews.controller.fragment



import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shin.mynews.R
import com.example.shin.mynews.model.dataClass.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_news.*


class DetailNewsFragment : Fragment() {
    fun newInstance(news: Results): DetailNewsFragment {
        val fragment = DetailNewsFragment()
        val args = Bundle()
        args.putSerializable("detail",news)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_news, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news = this.arguments!!.getSerializable("detail") as Results

        /**comparaison formmat
         * show image in image view
         * */
        if (news?.multimedia != null && !news?.multimedia.isEmpty()){
            Picasso.with(context).load(news.multimedia[2]?.url).into(image_detail_news)
        }
        if (news?.media?.first()?.mediaImage?.first()?.urlImage != null && news.multimedia?.first()?.url == null){
            Picasso.with(context).load(news.media?.first()?.mediaImage[2]?.urlImage).into(image_detail_news)
        }
        title_detail_news.setText(news.title)
        detail_section.setText(news.section)
        detail_url.setText(news.urlArticle)
    }
}
