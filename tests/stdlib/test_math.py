from unittest import expectedFailure

from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):

    #######################################################
    # factorial
    def test_factorial(self):
        self.assertCodeExecution("""
            from math import factorial
            x = 2
            y = 3
            z = 4
            w = 5
            print(factorial(x))
            print(factorial(y))
            print(factorial(z))
            print(factorial(w))
        """)
