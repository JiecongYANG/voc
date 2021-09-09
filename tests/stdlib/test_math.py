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

    def test_fabs(self):
        self.assertCodeExecution("""
            import math
            x1 = 0.0
            x2 = 0.9
            x3 = -1.1
            x4 = -1
            x5 = 10
            x6 = 0
            print(math.fabs(x1))
            print(math.fabs(x2))
            print(math.fabs(x3))
            print(math.fabs(x4))
            print(math.fabs(x5))
            print(math.fabs(x6))
        """)

    @unittest.expectedFailure
    def test_fabs_incorrect(self):
        self.assertCodeExecution("""
            import math
            x7 = "incorrect input"
            print(math.fabs(x7))
        """)
