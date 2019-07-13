#pragma once
#include "types.h"
#include <math.h>

s calculateDistanceUniformLinearMotion(v vt, t tt, t t0);

s calculateDistanceNonUniformLinearMotion(v vt, v v0, a at);

v calculateSpeedNonUniformLinearMotion(a at, t tt, t t0, v v0);