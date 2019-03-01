package ma.mohamed.codingchallenge.data.model

data class LoadingState(val state: State, val msg: String? = null) {
    enum class State {
        /** Represents the initial loading of the data right when the app is launched **/
        INITIAL_LOADING,
        /** Represents the loading of a page of data **/
        LOADING,
        /** Represents an error that happened when loading a page of data **/
        LOADING_ERROR,
        /** Represents a successful loading of data **/
        SUCCESS
    }

    companion object {
        val INITIAL_LOADING = LoadingState(State.INITIAL_LOADING)
        val LOADING = LoadingState(State.LOADING)
        val SUCCESS = LoadingState(State.SUCCESS)
        fun error(msg: String): LoadingState = LoadingState(State.LOADING_ERROR, msg)
    }
}