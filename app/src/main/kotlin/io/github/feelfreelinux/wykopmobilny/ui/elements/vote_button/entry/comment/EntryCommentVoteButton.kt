package io.github.feelfreelinux.wykopmobilny.ui.elements.vote_button.entry.comment

import android.content.Context
import android.util.AttributeSet
import io.github.feelfreelinux.wykopmobilny.WykopApp
import io.github.feelfreelinux.wykopmobilny.ui.elements.vote_button.base.BaseVoteButton
import javax.inject.Inject

class EntryCommentVoteButton : BaseVoteButton, EntryCommentVoteButtonView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @Inject lateinit var presenter : EntryCommentVoteButtonPresenter

    override fun unvote() {
        presenter.unvote()
    }

    override fun vote() {
        presenter.vote()
    }

    fun setCommentData(entryId : Int, commentId : Int, entryVotes : Int) {
        WykopApp.uiInjector.inject(this)
        presenter.subscribe(this)
        presenter.entryId = entryId
        presenter.commentId = commentId
        voteCount = entryVotes
    }
}