package chapter5.exercises.ex4

import chapter5.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

//tag::init[]
fun <A> Stream<A>.forAll(p: (A) -> Boolean): Boolean =
    foldRight({ true }, { a, b -> p(a) && b() })
    // fun go(xs: Stream<A>, n: Int): Boolean = when (xs) {
    //     is Empty -> true
    //     is Cons ->
    //         if (!p(xs.head())) false
    //         else go(xs.tail(), n - 1)
    // }
    // return go(this, 0)
//end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise4 : WordSpec({

    "Stream.forAll" should {
        "ensure that all elements match the predicate" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.forAll { it < 6 } shouldBe true
        }
        "stop evaluating if one element does not satisfy the predicate" {
            val s = Stream.of(1, 2, 3, 4, 5)
            s.forAll { it != 3 } shouldBe false
        }
    }
})
