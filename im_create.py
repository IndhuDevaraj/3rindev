import Image
import random
from PIL import Image
from PIL import ImageFont
from PIL import ImageDraw

m = int(raw_input( ))
for x in xrange (m):
	image = Image.new('RGB',(100,100),(random.randint(0,256), random.randint(0,256), random.randint(0,256)))
	draw = ImageDraw.Draw(image)
	font = ImageFont.truetype("FreeMonoBold.ttf", 16)
	draw.text((25,50),"LOTTERY NUMBER\n" + str(random.randint(1, 1000)), (255,255,255),font=font)
	image.save("output" + str(x) +".png")
