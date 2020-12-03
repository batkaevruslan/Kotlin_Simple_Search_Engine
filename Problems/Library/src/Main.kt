object Math {
    fun abs(a: Double): Double = if(a >= 0) a else a * -1
    fun abs(a: Int): Int = abs(a.toDouble()).toInt()
}
