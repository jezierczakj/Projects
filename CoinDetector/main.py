import cv2
import numpy as np

import skimage
from scipy.constants import sigma
from skimage.morphology import (square, rectangle, diamond, disk, octagon, star)
img1 = cv2.imread('coinsfin.tiff')
print(img1.size)
img = cv2.cvtColor(img1, cv2.COLOR_RGB2GRAY)
kernel = np.ones((5,5),np.float32)/25
blurred = cv2.filter2D(img,-1,kernel)
ret, thresh = cv2.threshold(blurred, 250, 255, cv2.THRESH_BINARY)
dilate = cv2.morphologyEx(thresh, cv2. MORPH_DILATE, disk(17))
erode = cv2.morphologyEx(dilate, cv2.MORPH_ERODE, disk(15))
contours, hierarchy = cv2.findContours(erode, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
print("Number of contours: ", len(contours))
total_area = 0; max = 0; min = 100000
real2p = 0

for i, cnt in enumerate(contours):

    area = cv2.contourArea(cnt)
    total_area += area
    if max < cv2.contourArea(cnt) and 100000 > cv2.contourArea(cnt):
        max = cv2.contourArea(cnt)
        print('max: ', max)
        real2p = area / 28.4
    if min > cv2.contourArea(cnt) and cv2.contourArea(cnt) > 0:
        min = cv2.contourArea(cnt)
        print('min: ', min)
        real5penny = area / 18

for i, cnt in enumerate(contours):
    area = cv2.contourArea(cnt)
    if area == max:
        print(f'Area of two pounds:', max)
        img1 = cv2.drawContours(img1, [cnt], -1, (200, 0, 0), 2)
    if area == min:
        img1 = cv2.drawContours(img1, [cnt], -1, (0, 100, 50), 2)

for i, cnt in enumerate(contours):
    M = cv2.moments(cnt)
    if M['m00'] != 0.0:
        x1 = int(M['m10'] / M['m00'])
        y1 = int(M['m01'] / M['m00'])
    area = cv2.contourArea(cnt)
    print('area: ', area)
    print('realp', 1.3436 - (max/area))

    if 1.3436 - max / area < 0.05 and 1.3436 - max / area > -0.05:
        print('Area of 10p', area)
        img1 = cv2.drawContours(img1, [cnt], -1, (0, 0, 250), 2)
        cv2.putText(img1, f'Area 10 pence :{area}', (x1, y1), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 255, 0), 1)
    if 1.953405902124642 - max / area < 0.05 and 1.953405902124642 - max / area > -0.05:
        print('Area of 1p', area)
        img1 = cv2.drawContours(img1, [cnt], -1, (250, 50, 250), 2)
        cv2.putText(img1, f'Area 1 pence :{area}', (x1, y1), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 255, 0), 1)
    if 1.202372591819303 - max / area < 0.05 and 1.202372591819303 - max / area > -0.05:
        print('Area of 2p', area)
        img1 = cv2.drawContours(img1, [cnt], -1, (200, 100, 250), 2)
        cv2.putText(img1, f'Area 2 pence :{area}', (x1, y1), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 255, 0), 1)
    if 1.122477186143351 - max / area < 0.05 and 1.122477186143351 - max / area > -0.05:
        print('Area of 50p', area)
        img1 = cv2.drawContours(img1, [cnt], -1, (150, 150, 250), 2)
        cv2.putText(img1, f'Area 50 pence :{area}', (x1, y1), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 255, 0), 1)
    if 1.826667435623865 - max / area < 0.05 and 1.826667435623865 - max / area > -0.05:
        print('Area of 20p', area)
        img1 = cv2.drawContours(img1, [cnt], -1, (100, 200, 250), 2)
        cv2.putText(img1, f'Area 20 pence :{area}', (x1, y1), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 255, 0), 1)
    if 1.50942809717821 - max / area < 0.05 and 1.50942809717821 - max / area > -0.05:
        print('Area of 1P', area)
        img1 = cv2.drawContours(img1, [cnt], -1, (50, 250, 250), 2)
        cv2.putText(img1, f'Area 1 Pound :{area}', (x1, y1), cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0, 255, 0), 1)


print('total_area = ', total_area)
cv2.imshow("Image", img1)
cv2.imwrite("result2.tiff", img1)
cv2.waitKey(0)
cv2.destroyAllWindows()
