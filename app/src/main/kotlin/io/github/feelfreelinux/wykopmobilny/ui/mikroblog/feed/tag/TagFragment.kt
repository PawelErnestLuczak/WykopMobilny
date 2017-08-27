package io.github.feelfreelinux.wykopmobilny.ui.mikroblog.feed.tag

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kodein.instance
import io.github.feelfreelinux.wykopmobilny.api.WykopApi
import io.github.feelfreelinux.wykopmobilny.ui.mikroblog.feed.BaseFeedFragment
import io.github.feelfreelinux.wykopmobilny.utils.instanceValue
import kotlinx.android.synthetic.main.toolbar.*

class TagFragment : BaseFeedFragment(), TagContract.View {
    val entryTag by lazy { arguments.getString("TAG") }
    override val presenter by lazy { TagPresenter(kodein.instanceValue(), entryTag) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(false)
        navActivity.activityToolbar.title = "#" + entryTag
        presenter.subscribe(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        fun newInstance(entryTag: String): Fragment {
            val fragmentData = Bundle()
            val fragment = TagFragment()
            fragmentData.putSerializable("TAG", entryTag)
            fragment.arguments = fragmentData
            return fragment
        }
    }
}