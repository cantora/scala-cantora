package com.github

package cantora {

package Implicits {

	//inspired by http://stackoverflow.com/questions/5764049/most-elegant-repeat-loop-in-scala
	class Repeat(n: Int) {

		def times[A](fn: => A): Int = times { i: Int => fn }
		
		def times[A](fn: Int => A): Int = {
			for(i <- 1 to n) {
				fn(i)
			}

			return n
		}

	}
}

}

package object cantora {
	implicit def intToRepeat(i: Int): Implicits.Repeat = new Implicits.Repeat(i)
}