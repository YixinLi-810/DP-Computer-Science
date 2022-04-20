'''
Description: 0810
Author: Yixin Li
Date: 2021-12-27 14:31:47
LastEditors: Yixin Li
LastEditTime: 2021-12-27 14:41:54
'''
import os
from PyPDF2 import PdfFileWriter, PdfFileReader

# ===============
i_pdf = '1.pdf'
first_page = 14

topics = [
    (1, 'top1.system.foundantals'),
    (61, 'top2.computer.oganization'),
    (124, 'top3.network'),
    (174, 'top4.computational.thinking'),
    (291, 'top5.oop'),
    (348, 'appendix'),
]

dir_out = 'output'
# ===============

'''
# ===============
i_pdf = 'Advanced Computer Science - Kostas Dimtriou and Markos Hatzitaskos - Express 2016.pdf'
first_page = 13

topics = [
    (1, 'top5.adt'),
    (68, 'top6.resource.management'),
    (95, 'top7.control'),
    (121, 'topD.oop'),
    (285, 'appendix.oop'),
]

dir_out = 'output'

'''

class PDF:
    def __init__(self, pdf_in, chapter_name, start, end, first_page):
        self.pdf_in = pdf_in
        self.chapter_name = chapter_name

        self.first_page = first_page
        self.differ = self.first_page - 2

        self.start = start + self.differ
        self.end = end + self.differ
        self.pdf_out = os.path.join(dir_out, self.chapter_name + '.pdf')

    def slice(self):
        # ag·gre·ga·tion
        inputpdf = PdfFileReader(open(self.pdf_in, "rb"))

        output = PdfFileWriter()
        for i in range(self.start, self.end + 1):
            output.addPage(inputpdf.getPage(i))

        with open(self.pdf_out, "wb") as ost:
            output.write(ost)

os.makedirs(dir_out, exist_ok=True)
for i in range(len(topics) - 1):
    start, chapter_name = topics[i]
    end, _ = topics[i + 1]
    ibcs = PDF(i_pdf, chapter_name, start, end - 1, first_page)
    ibcs.slice()