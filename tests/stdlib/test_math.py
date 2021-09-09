import unittest

from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    def test_trunc_positive(self):
        self.assertCodeExecution("""
            import math
            x = 3.1
            y = 0.9
            z = 2
            print(math.trunc(x))
            print(math.trunc(y))
            print(math.trunc(z))
        """)

    def test_trunc_negative(self):
        self.assertCodeExecution("""
            import math
            x = -1.1
            y = -0.9999999999999999999999999999999999
            z = -2
            print(math.trunc(x))
            print(math.trunc(y))
            print(math.trunc(z))
        """)

    @unittest.expectedFailure
    def test_trunc_exception(self):
        self.assertCodeExecution("""
            import math
            print(math.trunc('not a number'))
        """)
