import unittest

from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    def test_trunc1(self):
        self.assertCodeExecution("""
            import math
            x = 3.1
            y = 0.9
            print(math.trunc(x))
            print(math.trunc(y))
        """)

    def test_trunc2(self):
        self.assertCodeExecution("""
            import math
            x = -1.1
            y = -0.9999999999999999999999999999999999
            print(math.trunc(x))
            print(math.trunc(y))
        """)
