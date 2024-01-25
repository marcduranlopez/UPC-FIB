/********************************************************************************
** Form generated from reading UI file 'MyForm.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MYFORM_H
#define UI_MYFORM_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>
#include "MyGLWidget.h"

QT_BEGIN_NAMESPACE

class Ui_MyForm
{
public:
    MyGLWidget *widget;
    QWidget *widget1;
    QVBoxLayout *verticalLayout_4;
    QRadioButton *radioButton_3;
    QRadioButton *radioButton_5;
    QRadioButton *radioButton_4;
    QWidget *widget2;
    QVBoxLayout *verticalLayout;
    QVBoxLayout *verticalLayout_2;
    QRadioButton *radioButton;
    QRadioButton *radioButton_2;
    QSpacerItem *verticalSpacer_2;
    QVBoxLayout *verticalLayout_3;
    QSpacerItem *verticalSpacer;
    QPushButton *pushButton;

    void setupUi(QWidget *MyForm)
    {
        if (MyForm->objectName().isEmpty())
            MyForm->setObjectName(QString::fromUtf8("MyForm"));
        MyForm->resize(819, 726);
        widget = new MyGLWidget(MyForm);
        widget->setObjectName(QString::fromUtf8("widget"));
        widget->setGeometry(QRect(123, 6, 581, 686));
        QSizePolicy sizePolicy(QSizePolicy::Expanding, QSizePolicy::Expanding);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(widget->sizePolicy().hasHeightForWidth());
        widget->setSizePolicy(sizePolicy);
        widget->setMinimumSize(QSize(50, 50));
        widget1 = new QWidget(MyForm);
        widget1->setObjectName(QString::fromUtf8("widget1"));
        widget1->setGeometry(QRect(0, 0, 115, 80));
        verticalLayout_4 = new QVBoxLayout(widget1);
        verticalLayout_4->setObjectName(QString::fromUtf8("verticalLayout_4"));
        verticalLayout_4->setContentsMargins(0, 0, 0, 0);
        radioButton_3 = new QRadioButton(widget1);
        radioButton_3->setObjectName(QString::fromUtf8("radioButton_3"));

        verticalLayout_4->addWidget(radioButton_3);

        radioButton_5 = new QRadioButton(widget1);
        radioButton_5->setObjectName(QString::fromUtf8("radioButton_5"));

        verticalLayout_4->addWidget(radioButton_5);

        radioButton_4 = new QRadioButton(widget1);
        radioButton_4->setObjectName(QString::fromUtf8("radioButton_4"));

        verticalLayout_4->addWidget(radioButton_4);

        widget2 = new QWidget(MyForm);
        widget2->setObjectName(QString::fromUtf8("widget2"));
        widget2->setGeometry(QRect(710, 6, 103, 691));
        verticalLayout = new QVBoxLayout(widget2);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        radioButton = new QRadioButton(widget2);
        radioButton->setObjectName(QString::fromUtf8("radioButton"));

        verticalLayout_2->addWidget(radioButton);

        radioButton_2 = new QRadioButton(widget2);
        radioButton_2->setObjectName(QString::fromUtf8("radioButton_2"));

        verticalLayout_2->addWidget(radioButton_2);


        verticalLayout->addLayout(verticalLayout_2);

        verticalSpacer_2 = new QSpacerItem(10, 40, QSizePolicy::Minimum, QSizePolicy::Fixed);

        verticalLayout->addItem(verticalSpacer_2);

        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));

        verticalLayout->addLayout(verticalLayout_3);

        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout->addItem(verticalSpacer);

        pushButton = new QPushButton(widget2);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));
        QSizePolicy sizePolicy1(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(pushButton->sizePolicy().hasHeightForWidth());
        pushButton->setSizePolicy(sizePolicy1);

        verticalLayout->addWidget(pushButton);


        retranslateUi(MyForm);
        QObject::connect(pushButton, SIGNAL(clicked()), MyForm, SLOT(close()));
        QObject::connect(radioButton, SIGNAL(clicked()), widget, SLOT(setCamPerspectiva()));
        QObject::connect(radioButton_2, SIGNAL(clicked()), widget, SLOT(setCamPlanta()));
        QObject::connect(radioButton_3, SIGNAL(clicked()), widget, SLOT(patricioCub1()));
        QObject::connect(radioButton_5, SIGNAL(clicked()), widget, SLOT(patricioCub2()));
        QObject::connect(radioButton_4, SIGNAL(clicked()), widget, SLOT(patricioCub3()));

        QMetaObject::connectSlotsByName(MyForm);
    } // setupUi

    void retranslateUi(QWidget *MyForm)
    {
        MyForm->setWindowTitle(QApplication::translate("MyForm", "IDI-Lab", nullptr));
        radioButton_3->setText(QApplication::translate("MyForm", "Patricio Cub 1", nullptr));
        radioButton_5->setText(QApplication::translate("MyForm", "Patricio Cub 2", nullptr));
        radioButton_4->setText(QApplication::translate("MyForm", "Patricio Cub 3", nullptr));
        radioButton->setText(QApplication::translate("MyForm", "Perspectiva", nullptr));
        radioButton_2->setText(QApplication::translate("MyForm", "Planta", nullptr));
        pushButton->setText(QApplication::translate("MyForm", "&Sortir", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MyForm: public Ui_MyForm {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MYFORM_H
