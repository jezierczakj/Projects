import cv2
import numpy as np
from matplotlib import pyplot as plt
from skimage.morphology import (square, rectangle, diamond, disk, octagon, star)

line_in = (0, 300)
line_out = (1260, 200)
img1 = cv2.imread('2x_m004.jpg')
line_area = 0
h, w, _ = img1.shape
print('width: ', w)
print('height:', h)
rw = w * 0.019921875
rh = h * 0.019921875
ra = rw * rh
print ("real_width", rw)
print ("real_height", rh)
print ("real_area", ra)

print(img1.size)
img = cv2.cvtColor(img1, cv2.COLOR_RGB2GRAY)
hist = cv2.calcHist(img,[0],None,[256],[0,256])
plt.plot(hist)
plt.title('Image Histogram For Blue Channel GFG')
plt.show()
kernel = np.ones((5,5),np.uint8)/25
blurred = cv2.filter2D(img, -1, kernel)
ret, thresh = cv2.threshold(blurred, 125, 255, cv2.THRESH_BINARY)
ret, thresh1 = cv2.threshold(blurred, 220, 255, cv2.THRESH_BINARY)
thresh = np.bitwise_xor(thresh1, thresh)
thresh = cv2.morphologyEx(thresh, cv2.MORPH_OPEN, disk(5))

contours, hierarchy = cv2.findContours(thresh, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)

original = img1, np.uint8
linebck = np.zeros((img1.shape))
line = cv2.line(linebck, line_in, line_out, (255, 255, 255), 3)
print("Number of contours: ", len(contours))
total_area = 0


new_blank = np.zeros(img1.shape, np.uint8)
new_blank.fill(0)
cv2.fillPoly(new_blank, pts =contours, color=(255,255,255))
cv2.imshow("thr", new_blank)
cv2.waitKey(0)
cv2.destroyAllWindows()




for i, cnt in enumerate(contours):

    area = cv2.contourArea(cnt)
    total_area += area
    #print(f'Area of contour {i + 1}:', area)
    blank = np.zeros(img1.shape)
    img1 = cv2.drawContours(img1, [cnt], -1, (0, 0, 255), 3)


    image1 = cv2.drawContours(blank.copy(), [cnt], -1, 1)
    if (np.logical_and(image1, line)).any():
        img1 = cv2.drawContours(img1, [cnt], -1, (255, 255, 0), 2)
        line_area += cv2.contourArea(cnt)
        print (f"Przeciete: {i + 1}")

img1 = cv2.line(img1, line_in, line_out, (255, 255, 255), 3)
print('całkowite pole wykrytych obiektów:  ', total_area)
avg_real_area = total_area / (rw * rh) / len(contours)
part_of_area = total_area / w / h * 100
print ("średnie pole powierzchni konturów: ", avg_real_area)
print ("część pola: ", part_of_area, "%")
print ("pole przeciętych", line_area / w / h * 100)
print ("stosunek przeciętych do wszystkich", line_area / total_area * 100, "%")
cv2.imshow("Image", np.bitwise_and(img1, new_blank))
cv2.imshow("Line: ", img1)
cv2.waitKey(0)
cv2.destroyAllWindows()
